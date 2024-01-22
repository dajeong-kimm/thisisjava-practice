package ch19.exercise04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
	private static ServerSocket serverSocket = null;
	private static ExecutorService executorService = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("종료하려면 큐를 누르세요. ");
		
		startServer();
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			String key = scanner.nextLine();
			if(key.equals("q")) break;
		}
		
		scanner.close();
		
		stopServer();

	}
	
	public static void startServer() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					serverSocket = new ServerSocket(50001);
					
					while(true) {
						Socket socket = serverSocket.accept();
						
						executorService.execute(()->{
							try {
								InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
								System.out.println(isa.getHostName());
								
								//데이터 받기
								DataInputStream dis = new DataInputStream(socket.getInputStream());
								String receivedMsg = dis.readUTF();
								
								//데이터 주
								DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
								dos.writeUTF(receivedMsg);
								dos.flush();
								
								socket.close();
								
								
							} catch (IOException e) {
								
							}
						});
					}
					
					
				}catch (Exception e) {
					
				}
				
			}
		};
		thread.start();
	}
	
	public static void stopServer() {
		try {
			serverSocket.close();
			
		}catch (IOException e) {
			
		}
	}

}

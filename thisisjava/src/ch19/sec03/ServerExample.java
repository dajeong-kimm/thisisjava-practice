package ch19.sec03;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
	private static ServerSocket serverSocket = null;

	public static void main(String[] args) throws Exception{
		System.out.println("서버를 종료하려면 q or Q -> Enter");
		System.out.println("------------------------------");
		
		startServer();
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String key = scanner.nextLine();
			if(key.toLowerCase().equals("q")) {
				break;
			}
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
					System.out.println("[server] started");
					
					while(true) {
						System.out.println("\n[server] waiting connect request");
						
						Socket socket = serverSocket.accept();
						
						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						System.out.println("[server] "+isa.getHostName()+" accepted");
						
						socket.close();
						System.out.println("[server] "+isa.getHostName()+" Terminated connection");
					}
										
				} catch (IOException e) {
					System.out.println("[server]"+e.getMessage());
				}
			}
		};
		thread.start();
	}
	
	public static void stopServer() {
		try {
			serverSocket.close();
			System.out.println("[server] turn off");
			
		} catch(IOException e) {
			
		}
		
	}

}

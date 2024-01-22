package ch19.exercise01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
	private static ServerSocket serverSocket = null;

	public static void main(String[] args) {
		Serverstart();
		
		System.out.println("종료하고 싶으면 q를 누르세요.");

		Scanner scanner = new Scanner(System.in);
		while(true) {
			String key = scanner.nextLine();
			if(key.equals("q")) break;
			
		}
		scanner.close();
		
		stopServer();

	}

	public static void Serverstart() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					serverSocket = new ServerSocket(50002);
					
					System.out.println("[server]: started");
					
					while(true) {
						System.out.println("서버가 accept를 기다리는 중 ");
						Socket socket = serverSocket.accept();
						
						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						System.out.println("클라이언트의 IP 주소 : "+isa.getHostName()+"의 연결 요청을 수락함 ");
						
						socket.close();
						System.out.println("클라이언트와의 연결 끊었");
					}
					
				} catch (Exception e) {
					System.out.println("[server] : "+e.getMessage());
				}
				
			}
		};
		thread.start();
		
		
	}
	
	public static void stopServer() {
		try {
			serverSocket.close();
			System.out.println("서버 종료");
			
		} catch(IOException e) {
			
		}
		
	}

}

package ch19.sec04;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.Scanner;

public class NewsServer {
	private static DatagramSocket datagramSocket = null;

	public static void main(String[] args) {
		System.out.println("서버를 종료하려면 q를 입력하고 엔터");
		System.out.println("---------------------------");
		
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
					datagramSocket = new DatagramSocket(50001);
					System.out.println("[server] start");
					
					while(true) {
						DatagramPacket receivedPacket = new DatagramPacket(new byte[1024], 1024);
						datagramSocket.receive(receivedPacket);
						String newsKind = new String(receivedPacket.getData(), 0, receivedPacket.getLength(), "UTF-8");
						
						SocketAddress socketAddress = receivedPacket.getSocketAddress();
						
						for(int i=0;i<=10;i++) {
							String data = newsKind + ": 뉴스"+i;
							byte[] bytes = data.getBytes("UTF-8");
							DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length, socketAddress);
							datagramSocket.send(sendPacket);
						}
					}
					
				} catch(Exception e) {
					System.out.println("[server error message] "+e.getMessage());
				}
			}
		};
		thread.start();
	}
	
	public static void stopServer() {
		datagramSocket.close();
		System.out.println("[server] terminated");
	}

}

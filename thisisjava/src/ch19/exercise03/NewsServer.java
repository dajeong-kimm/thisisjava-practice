package ch19.exercise03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.Scanner;

public class NewsServer {
	private static DatagramSocket datagramSocket = null;

	public static void main(String[] args) {
		System.out.println("종료하고 싶으면 큐를 누르세요. ");
		System.out.println("-------------------------");

		startServer();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			String key = scanner.nextLine();
			if (key.toLowerCase().equals("q"))
				break;
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
					System.out.println("[서버] 시작됨");

					while (true) {
						DatagramPacket receivedPacket = new DatagramPacket(new byte[1024], 1024);
						datagramSocket.receive(receivedPacket);
						String newsKind = new String(receivedPacket.getData(), 0, receivedPacket.getLength(), "UTF-8");

						SocketAddress socketAddress = receivedPacket.getSocketAddress();

						for (int i = 1; i <= 10; i++) {
							String data = newsKind + i ;
							byte[] bytes = data.getBytes("UTF-8");
							DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length, socketAddress);
							datagramSocket.send(sendPacket);
						}

					}

				} catch (Exception e) {
					System.out.println("[서버]" + e.getMessage());
				}

			}
		};
		thread.start();
	}

	public static void stopServer() {
		datagramSocket.close();
		System.out.println("서버 종료됨 ");
	}

}

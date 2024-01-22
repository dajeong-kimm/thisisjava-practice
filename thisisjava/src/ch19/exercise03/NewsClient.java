package ch19.exercise03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class NewsClient {

	public static void main(String[] args) {
		try {
			DatagramSocket datagramSocket = new DatagramSocket();
			
			String data = "정치";
			byte[] bytes = data.getBytes("UTF-8");
			DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress("localhost", 50001));
			
			datagramSocket.send(sendPacket);
			System.out.println("클라이언트에서 서버에게 원하는 데이터의 종류를 보냈습니다. ");
			
			while(true) {
				DatagramPacket receivedPacket = new DatagramPacket(new byte[1024], 1024);
				datagramSocket.receive(receivedPacket);
				
				String news = new String(receivedPacket.getData(), 0, receivedPacket.getLength(), "UTF-8");
				System.out.println(news);
				
				if(news.contains("뉴스10")) {
					break;
				}
			}
			datagramSocket.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

package ch19.exercise02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 50001);
			
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			String msg = "나는 자바가 좋아용 ";
			dos.writeUTF(msg);
			dos.flush();
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String receivedMsg = dis.readUTF();
			System.out.println("[클라이언트] 데이터 받음 : "+receivedMsg);
			
			socket.close();
			
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}

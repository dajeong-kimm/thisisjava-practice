package ch19.sec03;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample {

	public static void main(String[] args) throws Exception {
		try {
			Socket socket = new Socket("localhost", 50001);
			
			System.out.println("[client] connection success");
			
			socket.close();
			System.out.println("[client] Disconnected");
			
		} catch(UnknownHostException e) {
			
		} catch (IOException e) {
			
		}

	}

}

package 채팅서버update;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) {
		Socket socket;
		ServerSocket serversocket;
		BufferedReader in;
		PrintWriter out;
		try {
			serversocket = new ServerSocket(5000);
			System.out.println("연결을 기다리고 있음.");
			socket = serversocket.accept();
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("클라이언트와 연결되었음");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

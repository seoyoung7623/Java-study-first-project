package ä�ü���update;

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
			System.out.println("������ ��ٸ��� ����.");
			socket = serversocket.accept();
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("Ŭ���̾�Ʈ�� ����Ǿ���");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

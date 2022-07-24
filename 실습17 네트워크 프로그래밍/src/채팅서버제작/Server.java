package ä�ü�������;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			serverSocket = new ServerSocket(5000); //��Ʈ��ȣ ���Ǽ���
			System.out.println("������ ��ٸ��� ����.");
			clientSocket = serverSocket.accept(); //������ Ŭ���̾�Ʈ�� ������ �õ��ϱ⸦ ��ٸ�.
			out = new PrintWriter(clientSocket.getOutputStream()); //�������� ���� ��Ʈ����ü�� ����.
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			System.out.println("Ŭ���̾�Ʈ�� ����Ǿ���.");
			
			while (true) {
				String msg = in.readLine(); //in���������� ����
				if(msg.equalsIgnoreCase("quit")) {
					System.out.println("Ŭ���̾�Ʈ���� ������ �����Ͽ���.");
					break;
				}
				System.out.println("Ŭ���̾�Ʈ�� ���� ���ڿ�: "+ msg);
				System.out.print("Ŭ���̾�Ʈ���� ���� ���ڿ��� �Է��ϰ� ����Ű�� ġ����:");
				String omsg = sc.nextLine();
				out.write(omsg+"\n");
				out.flush();
			}
			out.close();
			clientSocket.close();
			serverSocket.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
	}
}

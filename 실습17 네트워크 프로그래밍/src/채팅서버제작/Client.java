package ä�ü�������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException {
		Socket clientSocket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		final Scanner sc = new Scanner(System.in);
		
		try {
			//socket(int address,int port) �ּ� ��Ʈ��ȣ
			clientSocket = new Socket("localhost",5000);
			out = new PrintWriter(clientSocket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			String msg;
			while(true) {
				System.out.print("������ ���� ���ڿ��� �Է��ϰ� ����Ű�� ġ����:");
				msg = sc.nextLine(); //�Է��� �޼���
				if(msg.equalsIgnoreCase("quit")) {
					out.println(msg);
					out.flush();
					break;
				}
				out.println(msg); //�������Ͽ� �޼����� ������
				out.flush();
				msg = in.readLine(); //���������� �޼����� ����.
				System.out.println("�����κ��� �� �޽���:"+msg);
			}
			} catch (IOException e) {
				e.printStackTrace();
		} finally {
			out.close();
			clientSocket.close();
		}
	}
}

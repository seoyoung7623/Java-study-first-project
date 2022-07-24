package 채팅서버제작;

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
			//socket(int address,int port) 주소 포트번호
			clientSocket = new Socket("localhost",5000);
			out = new PrintWriter(clientSocket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			String msg;
			while(true) {
				System.out.print("서버에 보낼 문자열을 입력하고 엔터키를 치세요:");
				msg = sc.nextLine(); //입력할 메세지
				if(msg.equalsIgnoreCase("quit")) {
					out.println(msg);
					out.flush();
					break;
				}
				out.println(msg); //보낼파일에 메세지를 저장함
				out.flush();
				msg = in.readLine(); //받은파일의 메세지를 읽음.
				System.out.println("서버로부터 온 메시지:"+msg);
			}
			} catch (IOException e) {
				e.printStackTrace();
		} finally {
			out.close();
			clientSocket.close();
		}
	}
}

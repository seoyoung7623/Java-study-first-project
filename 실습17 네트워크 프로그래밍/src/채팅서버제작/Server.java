package 채팅서버제작;

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
			serverSocket = new ServerSocket(5000); //포트번호 임의설정
			System.out.println("연결을 기다리고 있음.");
			clientSocket = serverSocket.accept(); //서버는 클라이언트가 연결을 시도하기를 기다림.
			out = new PrintWriter(clientSocket.getOutputStream()); //소켓으로 부터 스트림객체를 얻음.
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			System.out.println("클라이언트와 연결되었음.");
			
			while (true) {
				String msg = in.readLine(); //in받은파일을 읽음
				if(msg.equalsIgnoreCase("quit")) {
					System.out.println("클라이언트에서 연결을 종료하였음.");
					break;
				}
				System.out.println("클라이언트가 보낸 문자열: "+ msg);
				System.out.print("클라이언트에게 보낼 문자열을 입력하고 엔터키를 치세요:");
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

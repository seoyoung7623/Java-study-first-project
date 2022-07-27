package Login;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;

import javax.swing.JFrame;

public class ChattingServer extends JFrame {
	public static ExecutorService threadPool;
	
	ServerSocket serverSocket;
	
	public void startServer(String IP,int port) {
		try {
			//서버 소켓을 호출한다
			serverSocket = new ServerSocket();
			//서버컴퓨터 역할을 수행하는 컴퓨터가 특정한 클라이언트의 접속을 기다림
			serverSocket.bind(new InetSocketAddress(IP, port));
		}catch (Exception e) {
			e.printStackTrace();
			//서버소켓이 닫혀있지 않다면 서버를 닫아준다.
			if(!serverSocket.isClosed()) {
				//stopServer();
			}
		}
	}
}

package Login;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;

import javax.swing.JFrame;

public class ChattingServer extends JFrame {
	public static ExecutorService threadPool;
	
	ServerSocket serverSocket;
	
	public void startServer(String IP,int port) {
		try {
			//���� ������ ȣ���Ѵ�
			serverSocket = new ServerSocket();
			//������ǻ�� ������ �����ϴ� ��ǻ�Ͱ� Ư���� Ŭ���̾�Ʈ�� ������ ��ٸ�
			serverSocket.bind(new InetSocketAddress(IP, port));
		}catch (Exception e) {
			e.printStackTrace();
			//���������� �������� �ʴٸ� ������ �ݾ��ش�.
			if(!serverSocket.isClosed()) {
				stopServer();
			}
		}
	}
	
	public void stopServer() {
		try {
//			//���� �۵� ���� ��� ���� �ݱ�
//			Iterator<Client> iterator = clients.iterator();
//			while(iterator.hasNext()) {
//				Client client = iterator.next();
//				client.socket.close();
//				iterator.remove();
//			}
			//���� ���� ��ü �ݱ�
			if(serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
			//������ Ǯ �����ϱ�
			if(threadPool != null && !threadPool.isShutdown()) {
				threadPool.shutdown();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
}

package chatting_swk3169;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ServerBack {
	private ServerSocket serverSocket;
	private Socket socket;
	private ServerGui gui;
	private String msg;
	
	private Map<String, DataOutputStream> clientMap = new HashMap<>();
	
	public void setGui(ServerGui gui) {
		this.gui = gui;
	}
	
	public ServerBack() throws IOException {
		Collections.synchronizedMap(clientMap);
		serverSocket = new ServerSocket(7777);
		while(true) {
			System.out.println("서버 대기중...");
			socket = serverSocket.accept();
			System.out.println(socket.getInetAddress()+"에서 접속했습니다.");
			Receiver receiver = new Receiver(socket);
			receiver.start();
		}
	}
	
	//맵 저장 삭제
	public void addClient(String nick,DataOutputStream out) throws IOException{
		sendMessage(nick+"님이 접속했습니다.");
		clientMap.put(nick, out);
	}
	
	public void removeClient(String nick) {
		sendMessage(nick+"님이 나가셨습니다.");
		clientMap.remove(nick);
	}
	
	public void sendMessage(String msg) {
		Iterator<String> it = clientMap.keySet().iterator();
		String key = "";
		while(it.hasNext()) {
			key = it.next();
			try {
				clientMap.get(key).writeUTF(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	class Receiver extends Thread{
		private DataInputStream in;
		private DataOutputStream out;
		private String nick;
		
		public Receiver(Socket socket) throws IOException {
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			nick = in.readUTF();
			addClient(nick,out);
		}
		
		public void run() {
			try {
				while(in != null) {
					msg = in.readUTF();
					sendMessage(msg);
					gui.appendMsg(msg);
				}
			}catch (IOException e) {
				// TODO: handle exception
				removeClient(nick);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		ServerBack s= new ServerBack();
	}
}


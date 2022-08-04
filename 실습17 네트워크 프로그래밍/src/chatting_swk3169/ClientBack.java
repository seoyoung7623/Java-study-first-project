package chatting_swk3169;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientBack {
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private ClientGui gui;
	private String msg;
	private String nickname;
	
	public final void setGui(ClientGui gui) {
		this.gui = gui;
	}
	
	public void connet() {
		try {
			socket = new Socket("127.0.0.1",7777);
			System.out.println("서버 연결됨.");
			
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			
			out.writeUTF(nickname);
			System.out.println("클라이언트: 메시지 전송완료");
			while (in != null) {
				msg = in.readUTF();
				gui.appendMsg(msg);
			}
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String msg2) {
		try {
			out.writeUTF(msg2);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public static void main(String[] args) {
		ClientBack cb = new ClientBack();
		cb.connet();
	}
}

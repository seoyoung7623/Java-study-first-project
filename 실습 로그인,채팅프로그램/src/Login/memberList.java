package Login;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class memberList {
	String name, id;
	char[] pwd;
	Socket socket;
	
	public memberList(Socket socket) {
		this.socket = socket;
		receive();
	}
	
	public memberList(String name, String id, char[] pwd) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	
	public void receive() {
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
						InputStream in = socket.getInputStream();
						byte[] buffer = new byte[512];
						int length = in.read(buffer);
						while(length == -1) throw new IOException();
						//�޽����� �� ���� ���� ��巹���� ������ �̸��� print�Ѵ�.
						System.out.println("[�޽��� ���� ����]" + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName());
						String message = new String(buffer, 0, length, "UTF-8");
						//���޹��� �޽����� �ٸ� Ŭ���̾�Ʈ���Ե� ����
						for(memberList client : EnterFrame.member) {
							client.send(message);
						}
					}
				}catch(Exception e) {
					try {
						System.out.println("[�޽��� ���� ����] " + socket.getRemoteSocketAddress() + " : " + Thread.currentThread().getName());
					}catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
			}
		};
		//threadpool�� thread ����
		ChattingFrame.threadPool.submit(thread);
	}
	
	public void send(String message) {
		Runnable thread = new Runnable() {
			
			@Override
			public void run() {
				try {
					OutputStream out = socket.getOutputStream();
					//OutputStream ����Ʈ ��Ʈ��
					byte[] buffer = message.getBytes("UTF-8");
					out.write(buffer);
					out.flush(); 
				} catch (Exception e) {
					// TODO: handle exception
					try {
						System.out.println("[�޽��� �۽� ����]"+ socket.getRemoteSocketAddress()+": "+ Thread.currentThread().getName());
						EnterFrame.member.remove(memberList.this);
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
				
			}
		};
		ChattingFrame.threadPool.submit(thread);			//�̰� �����־���..			
	}
}

package application;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	Socket socket;
	
	public Client(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		receive();
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
						System.out.println("[메시지 수신 성공]" + socket.getRemoteSocketAddress()+ ": "+ Thread.currentThread().getName());
						String message = new String(buffer,0,length,"UTF-8");
						for(Client client : Main.clients) {
							client.send(message);
						}
					}
				} catch (Exception e) {
					try {
					System.out.println("[메시지 수신 오류]"+ socket.getRemoteSocketAddress()+": "+Thread.currentThread().getName());
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				}
			}
		};
		Main.threadPool.submit(thread);
	}
	
	public void send(String message) {
		Runnable thread = new Runnable() {
			
			@Override
			public void run() {
				try {
					OutputStream out = socket.getOutputStream();
					byte[] buffer = message.getBytes("UTF-8");
					out.write(buffer);
					out.flush();
				} catch (Exception e) {
					// TODO: handle exception
					try {
						System.out.println("[메시지 송신 오류]"+ socket.getRemoteSocketAddress()+": "+ Thread.currentThread().getName());
						Main.clients.remove(Client.this);
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
				
			}
		};
				
				
	}
}

package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChattingFrame extends JFrame {
	
	private String myName;
	private JPanel contentPane;
	JTextArea textArea;
	private JPanel p2;
	JTextField sendField;
	JButton sendBtn;
	public static ExecutorService threadPool;
	private JPanel userP;
	JLabel userLab;
	
	Socket socket;
	ChattingServer chattingServer;
	
	public void startClient(String IP, int port) {
		Thread thread = new Thread() {
		public void run() {
			try {
				socket = new Socket(IP,port);
				receive();
			} catch (Exception e) {
				if(!socket.isClosed()) {
					stopClient();
					System.out.println("[서버 접속 실패]");
				}
			}
		}
		};
		thread.start();
	}
	
	
	public void stopClient() {
		try {
			if(socket != null && !socket.isClosed()) {
				socket.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void receive() {
		while(true) {
			try {
				InputStream in = socket.getInputStream();
				byte[] buffer = new byte[512];
				int length = in.read(buffer);
				if(length == -1) throw new IOException();
				String message = new String(buffer,0,length,"UTF-8");
				textArea.append(message);
			} catch (Exception e) {
				stopClient();
				break;
			}
		}
	}
	
	public void send(String message) {
		Thread thread = new Thread() {
			public void run() {
				try {
					OutputStream out = socket.getOutputStream();
					byte[] buffer = message.getBytes("UTF-8");
					out.write(buffer);
					out.flush();
				} catch (Exception e) {
					// TODO: handle exception
					stopClient();
				}
			}
		};
		thread.start();
	}
	
	public void myname(String myName) {
		this.myName = myName;
	}
	public ChattingFrame() throws IOException {
		String IP = "127.0.0.1";
		int port = 9876;
		
		chattingServer = new ChattingServer();
		chattingServer.startServer(IP, port);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel p1 = new JPanel();
		contentPane.add(p1);
		p1.setBorder(BorderFactory.createEmptyBorder(5,5,0,0));
		p1.setLayout(new BorderLayout(0, 0));
	
		textArea = new JTextArea("내용 \n");
		textArea.setEditable(false);
		p1.add(textArea);
		
		userP = new JPanel();
		p1.add(userP, BorderLayout.NORTH);
		userP.setLayout(new BorderLayout(0, 0));
		
		userLab = new JLabel("이름: ");
		userLab.setHorizontalAlignment(SwingConstants.CENTER);
		userP.add(userLab, BorderLayout.NORTH);
		
		p2 = new JPanel(); 
		contentPane.add(p2, BorderLayout.SOUTH);
		p2.setLayout(new BorderLayout(0, 0));
		
		sendField = new JTextField();
		p2.add(sendField);
		sendField.setColumns(10);
		
		sendBtn = new JButton("\uBCF4\uB0B4\uAE30");
		p2.add(sendBtn, BorderLayout.EAST);
		startClient(IP, port);
//		Platform.runLater(() -> {
//			textArea.append("[ 채팅방 접속 ]\n");
//		});
		
		sendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				send(myName + ": "+sendField.getText()+"\n");
				sendField.setText("");
				sendField.requestFocus();
			}
		});
	}

}

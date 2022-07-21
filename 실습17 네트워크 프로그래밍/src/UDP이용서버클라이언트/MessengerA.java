package UDP이용서버클라이언트;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MessengerA {
	protected JTextField txtField;
	protected JTextArea txtArea;
	DatagramSocket socket;
	DatagramPacket packet;
	InetAddress address = null;
	final int myPort = 5000;
	final int otherPort = 6000;
	
	public MessengerA() throws IOException{
		MyFrame f = new MyFrame();
		address = InetAddress.getByName("127.0.0.1");
		socket = new DatagramSocket(myPort);
		
	}
	
	//패킷을 받아서 텍스트 영역에 표시한다.
	public void process() {
		while (true) {
			try {
				byte[] buf = new byte[256];
				packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet); //패킷을 받는다.
				//받은 패킷을 텍스트영역에 표시한다.
				txtArea.append("RECIVER: "+new String(buf)+"\n");
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
					}
			}
		}	
	
	class MyFrame extends JFrame implements ActionListener{
		
		public MyFrame() {
			super("MessengerA");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
			
			txtField = new JTextField(30);
			txtField.addActionListener(this);
			
			txtArea = new JTextArea(10,30);
			txtArea.setEditable(false);
			
			add(txtField,BorderLayout.PAGE_END);
			add(txtArea,BorderLayout.CENTER);
			JScrollPane sp = new JScrollPane(txtArea);
			add(sp);
			pack();
			setVisible(true);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = txtField.getText();
			byte[] buffer = s.getBytes();
			DatagramPacket packet;
			packet = new DatagramPacket(buffer, buffer.length,address,otherPort);
			try {
				socket.send(packet);
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			txtArea.append("SENT: "+ s+"\n");
			txtField.selectAll();
			txtArea.setCaretPosition(txtArea.getDocument().getLength());
		}
	}
	
	public static void main(String[] args) throws IOException {
		MessengerA m = new MessengerA();
		m.process();
	}
}

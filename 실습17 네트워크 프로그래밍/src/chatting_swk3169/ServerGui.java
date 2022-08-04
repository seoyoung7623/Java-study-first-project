package chatting_swk3169;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerGui extends JFrame implements ActionListener{
	private JTextArea textArea = new JTextArea(40,25);
	private JTextField sendField =  new JTextField(25);
	private ServerBack server;
	
	public ServerGui() throws IOException {
		add(textArea,BorderLayout.CENTER);
		add(sendField,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(200,100,400,600);
		setTitle("서버부분");
		
		server.setGui(this);
		server = new ServerBack();
		sendField.addActionListener(this);
	}
	
	public void appendMsg(String msg) {
		textArea.append(msg);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = "서버: "+sendField.getText()+"\n";
		System.out.print(msg);
		server.sendMessage(msg);
		sendField.setText("");
		
	}
	public static void main(String[] args) throws IOException {
		new ServerGui();
	}
}

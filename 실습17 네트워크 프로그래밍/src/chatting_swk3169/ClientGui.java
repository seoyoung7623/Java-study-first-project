package chatting_swk3169;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGui extends JFrame implements ActionListener{
	private JTextArea textArea = new JTextArea(40,25);
	private JTextField sendField = new JTextField(25);
	private ClientBack client = new ClientBack();
	private static String nickName;
	
	public ClientGui() {
		add(textArea,BorderLayout.CENTER);
		add(sendField,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(800,100,400,600);
		setTitle("클라이언트");
		
		client.setGui(this);
		client.setNickname(nickName);
		client.connet();
		sendField.addActionListener(this);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("당신의 이름을 설정하세요 :");
		nickName = sc.nextLine();
		sc.close();
		
		new ClientGui();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = nickName + ": "+ sendField.getText()+"\n";
		client.sendMessage(msg);
		sendField.setText("");
	}
	
	public void appendMsg(String msg) {
		textArea.append(msg);
	}
}

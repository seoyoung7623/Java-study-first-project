package ä�ü���update;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.*;


public class EnterFramePT extends JFrame implements ActionListener {
	private JPasswordField pwT;
	private JTextField idT;// , pwT;
	private JButton idB, pwB, accessB, searchidB, searchpwB, membershipB;
	private JLabel loginL, logoutL;
	private ImageIcon loginC, logoutC, modifiedC;
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	
	private String sNumber = "><^^"; // default ��ũ���ѹ�
	private boolean condition_S = false; // �̸��� ����Ȯ��
	private boolean condition_Id = false; // ID �ߺ�üũ
	
	
	public EnterFramePT() {
//		network();
		
		idB = new JButton("���̵�");
		idT = new JTextField(15);
		pwB = new JButton("�н�����");
		pwT = new JPasswordField(15);
		pwT.setEchoChar('*');
		
		JPanel p2 = new JPanel(new FlowLayout());
		p2.add(idB);
		p2.add(idT);
		p2.add(pwB);
		p2.add(pwT);
		
		searchidB = new JButton("���̵� ã��");
		searchpwB = new JButton("��й�ȣ ã��");
		membershipB = new JButton("ȸ������");
		accessB = new JButton("����");
		
		JPanel p3 = new JPanel();
		p3.add(searchidB);
		p3.add(searchpwB);
		p3.add(membershipB);
		p3.add(accessB);
		
		loginC = new ImageIcon("img/�α���.png"); //
		loginL = new JLabel(loginC);//

		JPanel p4 = new JPanel();
		p4.add(loginL);

		Container contentPane = this.getContentPane();
		contentPane.add("Center", p2);
		contentPane.add("South", p3);
		contentPane.add("East", p4);

		setVisible(true);
		setResizable(false);
		setBounds(400, 200, 1000, 800);
	}
	
	public void event() {
		// --------------------ȸ�����԰���----------------------------------
		membershipB.addActionListener(this); // ȸ������(��ư)

		// --------------------IDã�����----------------------------------
		searchidB.addActionListener(this); // ���̵� ã��

		// --------------------PWã�����----------------------------------
		searchpwB.addActionListener(this); // PW ã��

		// --------------------�α��ΰ���----------------------------------
		accessB.addActionListener(this); // ����(Login)

		// ---------------------�޼��� ����---------------------------------

		// ----------------------�� ���� ------------------------------------

		// ----------------------ä�ù� ���� ---------------------------------


		//
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	public static void main(String[] args) {
		EnterFramePT e = new EnterFramePT();
	}

}

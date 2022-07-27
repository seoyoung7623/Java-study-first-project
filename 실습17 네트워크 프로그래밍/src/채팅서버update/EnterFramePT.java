package 채팅서버update;

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
	
	private String sNumber = "><^^"; // default 시크릿넘버
	private boolean condition_S = false; // 이메일 인증확인
	private boolean condition_Id = false; // ID 중복체크
	
	
	public EnterFramePT() {
//		network();
		
		idB = new JButton("아이디");
		idT = new JTextField(15);
		pwB = new JButton("패스워드");
		pwT = new JPasswordField(15);
		pwT.setEchoChar('*');
		
		JPanel p2 = new JPanel(new FlowLayout());
		p2.add(idB);
		p2.add(idT);
		p2.add(pwB);
		p2.add(pwT);
		
		searchidB = new JButton("아이디 찾기");
		searchpwB = new JButton("비밀번호 찾기");
		membershipB = new JButton("회원가입");
		accessB = new JButton("입장");
		
		JPanel p3 = new JPanel();
		p3.add(searchidB);
		p3.add(searchpwB);
		p3.add(membershipB);
		p3.add(accessB);
		
		loginC = new ImageIcon("img/로그인.png"); //
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
		// --------------------회원가입관련----------------------------------
		membershipB.addActionListener(this); // 회원가입(버튼)

		// --------------------ID찾기관련----------------------------------
		searchidB.addActionListener(this); // 아이디 찾기

		// --------------------PW찾기관련----------------------------------
		searchpwB.addActionListener(this); // PW 찾기

		// --------------------로그인관련----------------------------------
		accessB.addActionListener(this); // 입장(Login)

		// ---------------------메세지 관련---------------------------------

		// ----------------------방 관련 ------------------------------------

		// ----------------------채팅방 관련 ---------------------------------


		//
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	public static void main(String[] args) {
		EnterFramePT e = new EnterFramePT();
	}

}

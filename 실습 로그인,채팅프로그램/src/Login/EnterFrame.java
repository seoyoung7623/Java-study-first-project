package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EnterFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField idField;
	private JPasswordField pwdField;
	private JButton loginBtn, joinBtn;
	private JLabel idlab, pwdlab;
	
	ArrayList<memberList> member = new ArrayList<memberList>();
	MemberFrame memberFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnterFrame frame = new EnterFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EnterFrame() {
		
		memberFrame = new MemberFrame();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel p1 = new JPanel();
		contentPane.add(p1, BorderLayout.CENTER);
		p1.setLayout(null);
		
		idlab = new JLabel("ID");
		idlab.setBounds(220, 137, 39, 15);
		p1.add(idlab);
		
		idField = new JTextField();
		idField.setBounds(264, 134, 96, 21);
		p1.add(idField);
		idField.setColumns(10);
		
		pwdlab = new JLabel("PWD");
		pwdlab.setBounds(220, 186, 39, 15);
		p1.add(pwdlab);
		
		pwdField = new JPasswordField();
		pwdField.setBounds(264, 183, 96, 21);
		pwdField.setColumns(10);
		p1.add(pwdField);
		
		JPanel p2 = new JPanel();
		contentPane.add(p2, BorderLayout.SOUTH);
		
		loginBtn = new JButton("\uB85C\uADF8\uC778");
		p2.add(loginBtn);
		
		joinBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		p2.add(joinBtn);
		
		JPanel mainP = new JPanel();
		contentPane.add(mainP, BorderLayout.NORTH);
		
		JLabel mainLab = new JLabel("[\uBA40\uD2F0\uCC44\uD305\uD504\uB85C\uADF8\uB7A8]");
		mainLab.setFont(new Font("굴림", Font.BOLD, 16));
		mainP.add(mainLab);
		
		//event
		event();
	}
	
	public void event() {
		loginBtn.addActionListener(this);
		joinBtn.addActionListener(this);
		memberFrame.okBtn.addActionListener(this);
		memberFrame.resetBtn.addActionListener(this);
	};
	
	public void resetuserSet() {
		memberFrame.nameField.setText("");
		memberFrame.idField.setText("");
		memberFrame.pwdField.setText("");
		memberFrame.pwdFieldCk.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//메인화면 버튼	
		if(e.getSource() == joinBtn) { 
			this.setVisible(false);
			memberFrame.setVisible(true);
		}
		else if(e.getSource() == loginBtn){
			
		}
		
		//회원가입
		else if(e.getSource() == memberFrame.resetBtn) {
			resetuserSet();
		}
		else if(e.getSource() == memberFrame.okBtn) {
			char[] pwd = memberFrame.pwdField.getPassword();
			char[] pwdCk = memberFrame.pwdFieldCk.getPassword();
			String pwd1 = new String(pwd);
			String pwd2 = new String(pwdCk);
			if(pwd1.equals(pwd2)) {
				String username = memberFrame.nameField.getText();
				String userid = memberFrame.idField.getText();
				char[] userpwd = memberFrame.pwdField.getPassword();
				member.add(new memberList(username, userid, userpwd));
				JOptionPane.showMessageDialog(null, "정보가 등록되었습니다.");
				System.out.println(member);
				resetuserSet();
				memberFrame.setVisible(false);
				this.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다.");
				memberFrame.pwdField.setText("");
				memberFrame.pwdFieldCk.setText("");
			}
		}
	}

}

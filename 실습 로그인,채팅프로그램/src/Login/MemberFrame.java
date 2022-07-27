package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberFrame extends JFrame {

	private JPanel contentPane;
	JTextField nameField,idField;
	JPasswordField pwdField,pwdFieldCk;
	JButton resetBtn, okBtn;
	

	public MemberFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel p2 = new JPanel();
		contentPane.add(p2, BorderLayout.CENTER);
		p2.setLayout(null);
		
		JLabel nameLab = new JLabel("\uC774\uB984");
		nameLab.setBounds(214, 98, 50, 15);
		p2.add(nameLab);
		
		JLabel idLab = new JLabel("\uC544\uC774\uB514");
		idLab.setBounds(214, 136, 50, 15);
		p2.add(idLab);
		
		nameField = new JTextField();
		nameField.setBounds(305, 95, 96, 21);
		p2.add(nameField);
		nameField.setColumns(10);
		
		idField = new JTextField();
		idField.setBounds(305, 133, 96, 21);
		p2.add(idField);
		idField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_2.setBounds(214, 176, 67, 15);
		p2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uBE44\uBC00\uBC88\uD638\uD655\uC778");
		lblNewLabel_3.setBounds(214, 218, 79, 15);
		p2.add(lblNewLabel_3);
		
		pwdField = new JPasswordField();
		pwdField.setColumns(10);
		pwdField.setBounds(305, 173, 96, 21);
		p2.add(pwdField);
		
		pwdFieldCk = new JPasswordField();
		pwdFieldCk.setColumns(10);
		pwdFieldCk.setBounds(305, 215, 96, 21);
		p2.add(pwdFieldCk);
		
		JPanel p3 = new JPanel();
		contentPane.add(p3, BorderLayout.SOUTH);
		
		resetBtn = new JButton("\uC7AC\uC785\uB825");
		p3.add(resetBtn);
		
		okBtn = new JButton("\uD655\uC778");
		p3.add(okBtn);
		
		JPanel p1 = new JPanel();
		contentPane.add(p1, BorderLayout.NORTH);
		
		JLabel mainLab = new JLabel("<\uD68C\uC6D0\uC815\uBCF4>");
		mainLab.setFont(new Font("±¼¸²", Font.BOLD, 16));
		p1.add(mainLab);
		
		
		//action
	}
	
	
}

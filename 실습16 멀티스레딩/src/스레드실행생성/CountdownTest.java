package ������������;

import java.awt.Font;

import javax.swing.*;

public class CountdownTest extends JFrame{
	private JLabel label;
	
	class MyThread extends Thread{ //�����带 ����Ŭ������ ����� �ʵ忡 �����ϱ� ��������.
		public void run() {
			for(int i=0;i<=10;i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				label.setText(i+""); //1�ʰ� ������ ���̺��� �ؽ�Ʈ�� ����ȴ�.
			}
		}
	}
	
	public CountdownTest() {
		setTitle("ī��Ʈ�ٿ�");
		setSize(400,150);
		label = new JLabel("Start");
		label.setFont(new Font("Serif",Font.BOLD,100));
		add(label);
		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		(new MyThread()).start();
	}
	
	public static void main(String[] args) {
		CountdownTest c = new CountdownTest();
	}
}

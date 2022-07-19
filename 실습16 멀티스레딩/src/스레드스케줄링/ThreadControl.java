package �����彺���ٸ�;

import java.awt.Font;

import javax.swing.*;

public class ThreadControl extends JFrame{
	private JLabel label;
	Thread t;
	
	class Counter extends Thread{
		public void run() {
			for(int i=0;i<10;i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					return; //return ������ ����
				}
				label.setText(i+"");
			}
		}
	}
	
	public ThreadControl() {
		setTitle("ī��Ʈ�ٿ�");
		setSize(400,150);
		getContentPane().setLayout(null);
		label = new JLabel("Start");
		label.setBounds(0,0,384,111);
		label.setFont(new Font("serif",Font.BOLD,100));
		getContentPane().add(label);
		
		JButton btn = new JButton("����");
		btn.setBounds(247,25,100,23);
		btn.addActionListener(e -> t.interrupt()); //��ư�� �������� interrupt()�� ȣ���Ѵ�.
		getContentPane().add(btn);
		
		setVisible(true);
		t = new Counter();
		t.start();
	}
	
	public static void main(String[] args) {
		ThreadControl t =new ThreadControl();
	}
}

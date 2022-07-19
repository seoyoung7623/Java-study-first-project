package 스레드스케줄링;

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
					return; //return 스레드 중지
				}
				label.setText(i+"");
			}
		}
	}
	
	public ThreadControl() {
		setTitle("카운트다운");
		setSize(400,150);
		getContentPane().setLayout(null);
		label = new JLabel("Start");
		label.setBounds(0,0,384,111);
		label.setFont(new Font("serif",Font.BOLD,100));
		getContentPane().add(label);
		
		JButton btn = new JButton("중지");
		btn.setBounds(247,25,100,23);
		btn.addActionListener(e -> t.interrupt()); //버튼이 눌렸을때 interrupt()를 호출한다.
		getContentPane().add(btn);
		
		setVisible(true);
		t = new Counter();
		t.start();
	}
	
	public static void main(String[] args) {
		ThreadControl t =new ThreadControl();
	}
}

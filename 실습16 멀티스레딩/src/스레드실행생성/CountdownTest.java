package 스레드실행생성;

import java.awt.Font;

import javax.swing.*;

public class CountdownTest extends JFrame{
	private JLabel label;
	
	class MyThread extends Thread{ //스레드를 내부클래스로 만들면 필드에 접근하기 쉬워진다.
		public void run() {
			for(int i=0;i<=10;i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				label.setText(i+""); //1초가 지나면 레이블의 텍스트가 변경된다.
			}
		}
	}
	
	public CountdownTest() {
		setTitle("카운트다운");
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

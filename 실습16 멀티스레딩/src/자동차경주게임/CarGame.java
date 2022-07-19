package 자동차경주게임;

import java.awt.Image;
import javax.swing.*;

public class CarGame extends JFrame{
	
	class MyThread extends Thread{
		private JLabel label;
		private int x,y;
		
		public MyThread(String fname,int x,int y) {
			this.x = x;
			this.y = y;
			label = new JLabel();
			Image img = new ImageIcon(fname).getImage();
			Image changeimg = img.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
			label.setIcon(new ImageIcon(changeimg));
			label.setBounds(x,y,100,100);
			add(label);
		}
		
		public void run() {
			for(int i=0;i<200;i++) {
				x += 10* Math.random();
				label.setBounds(x,y,100,100);
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
	public CarGame() {
		setTitle("자동차게임");
		setSize(600,200);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		(new MyThread("car1.png", 100, 0)).start();
		(new MyThread("car2.png", 100, 50)).start();
		(new MyThread("car3.png", 100, 100)).start();
		setVisible(true);
	}
	public static void main(String[] args) {
		CarGame g = new CarGame();
	}
}

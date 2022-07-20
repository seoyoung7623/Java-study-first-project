package 공움직이기;

import java.awt.*;
import java.awt.Graphics;
import javax.swing.*;

public class MyPanel extends JFrame{
	static final int BOARD_WIDTH = 600;
	static final int BOARD_HEIGHT = 300;
	private Ball ball = new Ball();
	
	public MyPanel() {
		this.setBackground(Color.yellow);
		//패널생성과 동시에 패널 변경
		//람다식으로 runnable
		Runnable task = () ->{
			while (true) {
				ball.update();
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException ignore) {
					// TODO: handle exception
				}
			}
		};
		new Thread(task).start();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
		ball.draw(g);
	}
	
	public static void main(String[] args) {
		JFrame j = new JFrame();
		j.setSize(MyPanel.BOARD_WIDTH,MyPanel.BOARD_HEIGHT);
		j.add(new MyPanel());
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
	}
}

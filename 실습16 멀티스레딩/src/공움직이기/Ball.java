package �������̱�;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	private int x = 100,y = 100,size = 30,
			xSpeed = 10, ySpeed=10;
	
	public void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(x, y, size, size);
	}
	
	//���� ���ο� ��ġ���
	public void update() {
		x += xSpeed;
		y += ySpeed;
		//���� ȭ�� ������ ��������
		if ((x + size) > MyPanel.BOARD_WIDTH - size || x < 0) {
			xSpeed = -xSpeed;
		}
		if((y + size) > MyPanel.BOARD_HEIGHT - size || y < 0) {
			ySpeed = -ySpeed;
		}
	}
}

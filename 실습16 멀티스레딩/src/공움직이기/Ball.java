package 공움직이기;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	private int x = 100,y = 100,size = 30,
			xSpeed = 10, ySpeed=10;
	
	public void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(x, y, size, size);
	}
	
	//공의 새로운 위치계산
	public void update() {
		x += xSpeed;
		y += ySpeed;
		//공이 화면 밖으로 나갔을때
		if ((x + size) > MyPanel.BOARD_WIDTH - size || x < 0) {
			xSpeed = -xSpeed;
		}
		if((y + size) > MyPanel.BOARD_HEIGHT - size || y < 0) {
			ySpeed = -ySpeed;
		}
	}
}

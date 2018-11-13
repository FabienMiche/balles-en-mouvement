package balles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;

public class UI extends JLabel {
	Timer time;
	
	public UI(Timer time) {
		this.time = time;
		this.setFont(new Font("Emulogic", Font.BOLD, 12));
		this.setText("Score : " + time.getScore() + "Temps : " + time.getTimer());
		this.setForeground(Color.blue);
		this.setHorizontalAlignment(CENTER);
	}
	
	public void paintComponent(Graphics g) {
		this.setText("Score : " + time.getScore() + " Temps : " + time.getTimer());
		super.paintComponent(g);
		repaint();
	}
}

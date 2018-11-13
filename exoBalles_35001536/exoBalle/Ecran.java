package balles;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Ecran extends JPanel{
	Panneau panneau;
	int points = 0;
	
	public Ecran(Panneau panneau) {
		this.panneau = panneau;
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		panneau.paintComponent(g);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {e.printStackTrace();}
		repaint();
	}
	
}
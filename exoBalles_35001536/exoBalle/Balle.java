package balles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Balle {
	int posX, posY, radius, largeur,hauteur;
	boolean backX = false, backY = false;
	Color color;
	Random random = new Random();
	int redValue = random.nextInt(255);
	int greenValue = random.nextInt(255);
	int blueValue = random.nextInt(255);
	
	public Balle(int fenL, int fenH) {
		this.largeur = fenL + radius;
		this.hauteur = fenH + radius;
		this.radius = 50;
		posX = (int) (radius + (Math.random()) * (fenL - radius + 1));
		posY = (int) (radius + (Math.random()) * (fenH - radius + 1));
		this.color = new Color(redValue, greenValue, blueValue);
	}
	
	public void paintComponent(Graphics g) {
		Color color = new Color(redValue, greenValue, blueValue);
		g.setColor(Color.white);
		g.fillRect(0, 0, this.largeur, this.hauteur);
		g.setColor(color);
		g.fillOval(this.posX, this.posY,this.radius,this.radius);
	}
	
	
	public int getPosX() {return posX;}
	public int getPosY() {return posY;}
	public int getRadius() {return radius;}
	public Color getColor() {return color;}
	public int getTailleX() {return largeur;}
	public int getTailleY() {return hauteur;}
	
	public void setPosX(int posX) {this.posX = posX;}
	public void setPosY(int posY) {this.posY = posY;}
	public void setRadius(int radius) {this.radius = radius;}

	
	public void mouvement() {
		if(posX < 1) {backX = false;}
		if(posX > largeur - radius) {backX = true;}
		if(posY < 1) {backY = false;}
		if(posY > hauteur - radius) {backY = true;}
		
		if(!backX) {posX++;}
		else { posX--;}
		if(!backY) {posY++;}
		else {posY--;}
	}
	
	
	public boolean collision(Balle balle) {
		int d = (this.posX-balle.getPosX())*(this.posX-balle.getPosX()) + (this.posY-balle.getPosY())*(this.posY-balle.getPosY());
		
		if (d > (radius/25 + balle.getRadius())*(radius/25 + balle.getRadius())) {
			return false;
		} else {
			return true;
		}
	}
}

package balles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class Panneau extends Thread {
	ArrayList<Balle> balles = new ArrayList<Balle>();
	ArrayList<Balle> balles2 = new ArrayList<Balle>();
	Boolean state = false;
	Timer timer;
	
	public Boolean getEtat() {return state;}
	public void setEtat(Boolean pause) {state = pause;}
	
	public Panneau(Timer timer) {
		this.timer = timer;
		for(int i = 0; i < 5; i++) {
			balles.add(new Balle(800, 705));
		}
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		//g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for(Balle balle : balles) {
			g.setColor(balle.getColor());
			g.fillOval(balle.getPosX(), balle.getPosY(), balle.getRadius(), balle.getRadius());
			//System.out.println(balle.getRadius());
			//System.out.println(pause);
		}
	}

	public void run() {
		while(true) {
			if(state) {
				for(Balle balle : balles) {
					balle.mouvement();
					//System.out.println("Largeur : " +balle.getTailleX() + "Hauteur :" + balle.getTailleY());
				}
				for(int i = 0; i < balles.size(); i++) {
					for(int j = i + 1; j < balles.size(); j++) {
						if(balles.get(i).collision(balles.get(j))) {
							balles2.add(balles.get(i));
							balles2.add(balles.get(j));
							timer.setScore();
						}
					}
				}
				for(Balle balle: balles2) {
					balles.remove(balle);
				}
				//balles2.clear();
				
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {e.printStackTrace();}	
			}
			System.out.println("panneau state : " +state);
			System.out.println("panneau timer state : " + timer.getTimer());
		}
	}
	
	
	public void ajouterBalle(Balle ball) {
		balles.add(ball);
	}
	
	public void supprimerBalle() {
		if(balles.size() > 0) {
			balles.remove(balles.size() - 1);
		}
	}
	
	//Hors-consigne
	//Ajout des focntions gérant l'augmentation et la diminution de la taille
	public void taillePlus() {
		for(int i = 0; i < balles.size(); i++) {
			balles.get(i).radius+=10;
		}
	}
	
	public void tailleMoins() {
		for(int i = 0; i < balles.size(); i++) {
			balles.get(i).radius-=10;
		}
	}
}

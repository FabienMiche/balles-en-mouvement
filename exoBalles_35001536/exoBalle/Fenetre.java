package balles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	Timer timer = new Timer();
	Panneau panneau = new Panneau(timer);
	Ecran ecran = new Ecran(panneau);
	
	JPanel boutons = new JPanel();
	JButton start = new JButton("Start");
	JButton plus = new JButton("+");
	JButton moins = new JButton("-");
	JButton rPlus = new JButton("Taille+");
	JButton rMoins = new JButton("Taille-");
	
	JPanel textes = new JPanel();
	UI ui = new UI(timer);
	
	public Fenetre() {
		
		this.setTitle("Balles en mouvement");
	    this.setSize(800, 800);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    //this.setContentPane(panneau);
	    this.setVisible(true);
	    
	    ecran.setBackground(Color.white);
	    add(ecran);
	    add(boutons, BorderLayout.SOUTH);
	    add(textes, BorderLayout.NORTH);
	    boutons.setLayout(new FlowLayout());
	    boutons.add(start);
	    boutons.add(plus);
	    boutons.add(moins);
	    boutons.add(rPlus);
	    boutons.add(rMoins);
	    
	    textes.add(ui);
	    
	    start.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(panneau.getEtat()) {
	    			panneau.setEtat(false);
	    			timer.setEtat(false);
	    			start.setText("Start");
	    		} else {
	    			panneau.setEtat(true);
	    			timer.setEtat(true);
	    			start.setText("Stop");
	    		}
	    	}
	    });
	    
	    plus.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		if(panneau.balles.size() < 10) {
	    			panneau.ajouterBalle(new Balle(ecran.getWidth(), ecran.getHeight()));
	    		} else {
	    			
	    		}
	    		
	    	}
	    });
	    
	    moins.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panneau.supprimerBalle();
	    	}
	    });
	    
	    //Hors-consigne
	    //Ajout de boutons par simple plaisir et pour des tests 
	    
	    rPlus.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panneau.taillePlus();
	    		ecran.repaint();
	    	}
	    });
	    
	    rMoins.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panneau.tailleMoins();
	    	}
	    });
	    panneau.start();
	    timer.start();
	}
}
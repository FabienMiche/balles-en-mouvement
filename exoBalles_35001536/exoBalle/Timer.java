package balles;

public class Timer extends Thread {
	int timer = 0;
	int score = 0;
	boolean state = false;

	public int getTimer() {return timer;}
	public void setTimer(int timer) {this.timer = timer;}
	
	public int getScore() {return score;}
	public void setScore() {score++;}
	
	public void setEtat(boolean etat) {state = etat;}
	
	public void run() {
		while(true) {
			if(state) {
				try {
					timer++;
					sleep(1000);
				} catch(InterruptedException e) 
				// TODO Auto-generated catch block
				{e.printStackTrace();}
			} else {
				try {
					sleep(0);
				} catch(InterruptedException e) 
				// TODO Auto-generated catch block
				{e.printStackTrace();}
			}
		}
	}
}

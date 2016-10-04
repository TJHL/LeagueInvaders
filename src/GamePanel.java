import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState=MENU_STATE;
	RocketShip ship = new RocketShip(250,700,50,50);
	ObjectManager manager = new ObjectManager();
	Timer clock;
	Font titleFont;
	Font startFont;
	Font insructionFont;
	
	GamePanel(){
		clock = new Timer(1000 / 60,this);
		titleFont= new Font("Arial", Font.PLAIN,48);
		startFont= new Font("Arial", Font.PLAIN,24);
		insructionFont= new Font("Arial", Font.PLAIN,24);
		manager.addObject(ship); 
	}
	
	void startGame(){
		clock.start();
		
	}
	
	void updateMenuState(){
	
	}
	
	void updateGameState(){
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		
		if(ship.isAlive==false){
		currentState=END_STATE;
		ship.isAlive=true;
		//PROBLEM RIGHT HERE!!!!!!!!!!!!!!!
		manager.reset();
		}
	}
	
	void updateEndState(){
		
	}
	
	void drawMenuState(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 25, 200);
		g.setFont(startFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to start", 125, 300);
		g.setFont(insructionFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press SPACE for intructions", 90, 400);
		

	}
	
	void drawGameState(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);    
		manager.draw(g);

	}
	
	void drawEndState(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT); 
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 100, 100);
		g.setFont(startFont);
		g.setColor(Color.BLACK);
		g.drawString("You killed "+manager.getScore()+" aliens.", 150, 300);
		g.setFont(insructionFont);
		g.setColor(Color.BLACK);
		g.drawString("Press BACKSPACE to Restart", 90, 500);

	}
	
	public void paintComponent(Graphics g){
		if(currentState == MENU_STATE){
			drawMenuState(g);
		}
		
		else if(currentState == GAME_STATE){
			drawGameState(g);
		}
		
		else if(currentState == END_STATE){
			drawEndState(g);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
					//currentState++;
		if(currentState == MENU_STATE){
			updateMenuState();
		}
		
		else if(currentState == GAME_STATE){
			updateGameState();
		}
		
		else if(currentState == END_STATE){
			updateEndState();
		}
		
		repaint();
		if(currentState > END_STATE){
			currentState = MENU_STATE;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			currentState++;
			}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){	
			ship.left=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){	
		ship.right=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
		ship.up=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
		ship.down=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
		manager.addObject(new Projectile(ship.x-5, ship.y, 10, 10));
		manager.addObject(new Projectile(ship.x +45, ship.y, 10, 10));

		}
	}
	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		ship.left=false;
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
		ship.right=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
		ship.up=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
		ship.down=false;
		}
	}public void keyTyped(KeyEvent e) {}
}
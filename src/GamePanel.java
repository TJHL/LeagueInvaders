import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	GameObject object= new GameObject();
	Timer clock;
	GamePanel(){
		clock = new Timer(1000 / 60,this);
	}
	void startGame(){
		clock.start();
		
	}
	public void paintComponent(Graphics g){
		object.draw(g);

	}


	public void actionPerformed(ActionEvent e) {
		object.update();
		repaint();
		
	}
	
	public void keyTyped(KeyEvent e) {

	System.out.println("key typed");	
	}

	public void keyPressed(KeyEvent e) {
		System.out.println("key presssssssssssssssssss");
	}
	public void keyReleased(KeyEvent e) {
		System.out.println("key released!!!!!!");
	}
	

}

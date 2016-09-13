import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	GamePanel panel;
	final int WIDTH = 500;
	final int HIGHT = 800;
public static void main(String[] args) {
	
	LeagueInvaders a = new LeagueInvaders();
}
	LeagueInvaders(){
		 frame = new JFrame();
		 panel = new GamePanel();
		 setup();
	}
	void setup(){
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.setSize(WIDTH, HIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.startGame();
	}
}

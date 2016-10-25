import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameObject {
	
	int x;
	int y;
	int width;
	int height;
	Boolean isAlive=true;
	Rectangle collisionBox; 
	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;
	
	
	
	GameObject(){
	collisionBox= new Rectangle(x,y,width, height);	
	
	try {
		alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
		rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
		bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	}
	void update(){
	collisionBox.setBounds(x, y, width, height);
	}
	
	void draw(Graphics g){
	}
	Boolean isAlive(){
		
		return isAlive;
		
	}
}
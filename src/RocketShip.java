import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject {
	int speed;
	Boolean left=false;
	Boolean right=false;
	Boolean up=false;
	Boolean down=false;
	RocketShip(int x,int y, int width, int height){
	 this.x=x;
	 this.y=y;
	 this.width=width;
	 this.height=height;
	 speed=5;
	}
	void update(){
		if(left==true){
			x=x-speed;
		}
		if(right==true){
			x=x+speed;
		}
		if(up==true){
			y=y-speed;
		}
		if(down==true){
			y=y+speed;
		}
	}
	
	void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	
}
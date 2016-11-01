import java.awt.Graphics;

public class RocketShip extends GameObject {
	int speed;
	Boolean left=false;
	Boolean right=false;
	Boolean up=false;
	Boolean down=false;
	RocketShip(int x,int y, int width, int height){
	super();
	 this.x=x;
	 this.y=y;
	 this.width=width;
	 this.height=height;
	 speed=5;
	}
	void update(){
		super.update();
		if(left==true&&x>0){
			x=x-speed;
		}
		if(right==true&&x<450){
			x=x+speed;
		}
		if(up==true&&y>0){
			y=y-speed;
		}
		if(down==true&& y<726){
			y=y+speed;
		}
	}
	
	void draw(Graphics g){
		g.drawImage(this.rocketImg, x, y, width, height, null);
	}
	
}
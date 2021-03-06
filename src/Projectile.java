import java.awt.Graphics;

public class Projectile extends GameObject {
int speed;
	Projectile(int x,int y, int width, int height){
		super();
		 this.x=x;
		 this.y=y;
		 this.width=width;
		 this.height=height;
		 speed=10;
	}
	void update(){
		super.update();
		y=y-speed;
		if(y<=0){
			isAlive=false;
		}
	}
	void draw(Graphics g){
		g.drawImage(this.bulletImg, x, y, width, height, null);
	}
}
import java.awt.Graphics;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
void update(){
	x=x+6;
	y=y+6;
}
void draw(Graphics g){
	g.fillRect(x, y, 100, 100);
}
}

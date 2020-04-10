 	import java.awt.Rectangle;

public class GameObject {
	 int x;
	 int y;
	 public boolean isActive=true;
	 int width;
	 int height;
int speed=0;

Rectangle collisionBox;
public GameObject(int x, int y, int width, int height, int speed) {
	this.x=x;
	this.y=y;
	this.width=width;
	this.height=height;
	this.speed=speed;
	collisionBox=new Rectangle(10, 10, 10 , 10);
}
public void update( ) {
	collisionBox.setBounds(x, y, width, height);

}
}
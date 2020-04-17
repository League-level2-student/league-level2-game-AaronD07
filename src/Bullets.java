import java.awt.Color;
import java.awt.Graphics;

public class Bullets extends GameObject{
int moveSpeed=1;
	public Bullets(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g) {
		g.setColor(Color.RED);
	g.drawRect(x, 300, width, height);

	
	}
	
public void update() {
	super.update();
	x=x+moveSpeed;
	

}
}



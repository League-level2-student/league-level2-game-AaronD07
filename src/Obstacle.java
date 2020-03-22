import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Obstacle extends GameObject{

	
	public Obstacle(int x, int y, int width, int height) {
		super(x, y, width, height, 0);
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g) {
		Random random = new Random();
		Random random2 = new Random();
		g.setColor(Color.ORANGE);
		g.fillRect(random.nextInt(600), 0, 50, random.nextInt(450));
		g.fillRect(random2.nextInt(600), 500, 50, random.nextInt(400));
		
	}
}

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Obstacle {

	
	public void draw(Graphics g) {
		Random random = new Random();
		Random random2 = new Random();
		g.setColor(Color.ORANGE);
		g.fillRect(random.nextInt(600), 0, 50, random.nextInt(450));
		g.fillRect(random2.nextInt(600), 500, 50, random.nextInt(400));
		
	}
}

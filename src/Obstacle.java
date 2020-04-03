import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Obstacle extends GameObject {
	Random random = new Random();

	public Obstacle(int x, int y, int width, int height) {
		super(x, y, width, height, 0);
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g) {

		g.setColor(Color.ORANGE);
		g.fillRect(x, y, 50, height);

	}

	public void update() {
		super.update();
		x--;
		if (x < 0) {
			x = SharkGame.WIDTH;
			height = random.nextInt(600);
		}
	}
}

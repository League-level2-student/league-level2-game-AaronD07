import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class FishingRod extends GameObject {
	int growthSpeed = 1;

	public FishingRod(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		if (height > 300) {

			g.fillRect(x, y, 10, 300);
		} else {
			g.fillRect(x, y, 10, height);
		}
	}

	public void update() {
		super.update();
		height = height + growthSpeed;

		if (height > 500) {
			growthSpeed = -1;
		}
		else if(height<0) {
			growthSpeed = 1;
			x=new Random().nextInt(600);
		}

	}
}

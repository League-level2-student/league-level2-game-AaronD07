import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Shark extends GameObject {
	public Shark(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);
		// TODO Auto-generated constructor stub
	}

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);

		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
			System.out.println();
		}

		if (needImage) {
			loadImage("Shark.png");
			if (gotImage) {
				g.drawImage(image, x, y, width, height, null);
			} else {
				g.setColor(Color.BLUE);
				g.fillRect(x, y, width, height);
			}
		}

		if (needImage) {
			loadImage("Shark.png");
			if (gotImage) {
				g.drawImage(image, x, y, width, height, null);
			} else {
				g.setColor(Color.BLUE);
				g.fillRect(x, y, width, height);
			}
		}
	}

	public void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	public void update() {
		if (y > ProjectManager.fish.y) {
			y = y - speed;

		}
		if (y < ProjectManager.fish.y) {
			y = y + speed;
		}

	}
}

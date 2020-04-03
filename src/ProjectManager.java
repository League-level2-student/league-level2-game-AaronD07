import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ProjectManager extends JPanel implements KeyListener, ActionListener {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	final int GAME = 0;
	int END = 1;
	Timer framedraw;
	Fish fish;
	Shark shark;
	ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	int currentState = GAME;
	int score = 0;

	public ProjectManager() {

		Random random = new Random();

		loadImage("Background.jpg");
		fish = new Fish(200, 350, 50, 50, 1);
		shark = new Shark(5, 300, 150, 150, 1);
		int x = random.nextInt(600);
		obstacles.add(new Obstacle(x, 0, 50, random.nextInt(400)));
		obstacles.add(new Obstacle(x, 500, 50, random.nextInt(450)));
		int x2 = random.nextInt(600);
		obstacles.add(new Obstacle(x2, 0, 50, random.nextInt(400)));
		obstacles.add(new Obstacle(x2, 500, 50, random.nextInt(450)));
		startGame();

	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}

	}

	public void startGame() {
		framedraw = new Timer(1000 / 60, this);
		framedraw.start();

	}

	void updateGameState() {
		if (fish.isActive == false) {
			currentState = END;

		}
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).update();
		}
		checkCollision();
	}

	void updateEndState() {

	}

	@Override
	public void paintComponent(Graphics g) {

		if (currentState == GAME) {
			drawGameState(g);
			score = score + 1;
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	void drawGameState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, SharkGame.WIDTH, SharkGame.HEIGHT, null);
			fish.draw(g);
			shark.draw(g);

			score = score + 1;

		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, WIDTH, HEIGHT);

		}
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).draw(g);
		}
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.BLACK);
		g.drawString("SharkGame", 0, 50);

		g.setColor(Color.BLACK);
		g.drawString("You got a score of " + score + 0, 400, END);

		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to play again", 0, 600);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (currentState == GAME) {

			updateGameState();
		} else if (currentState == END) {
			updateEndState();

		}

		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("UP");
			if (fish.y >= 5) {
				fish.up();

			}

		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("DOWN");

			if (fish.y <= 600) {
				fish.down();
			}

		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("LEFT");
			if (fish.x >= 5) {
				fish.left();

			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("RIGHT");
			if (fish.x <= 795) {

				fish.right();

			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.out.println("REstart");

		}

	}

	public void checkCollision() {

		for (int o = 0; o < obstacles.size(); o++) {
			if (fish.collisionBox.intersects(obstacles.get(o).collisionBox)) {
				fish.isActive = false;
				System.out.println("After collision");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

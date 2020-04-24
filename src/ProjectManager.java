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
	double score = 0;
	int END = 1;
	Timer framedraw;
	public static Fish fish;
	Shark shark;
	Bullets bullet;
int bulletWidth;
int bulletHeight;
	static ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	int currentState = GAME;
	FishingRod rod;

	public ProjectManager() {

		loadImage("Background.jpg");

		fish = new Fish(200, 350, 50, 50, 3);
		createShark();
bulletWidth=40;
bulletHeight=15;
		bullet = new Bullets(20, shark.y+75, bulletWidth, bulletHeight, 4);		
		createFishingRod();
		createObstacles();
		
		startGame();

	}

	public void createFishingRod() {

		Random random = new Random();
		rod = new FishingRod(random.nextInt(800), 0, 10, 0, 1);
	}
	
	public void createShark() {
		shark = new Shark(5, 0, 150, 150, 1);
	}

	

	public static void createObstacles() {
		obstacles.clear();
		Random random = new Random();
		int x = SharkGame.WIDTH;
		int obstacleHeight3 = random.nextInt(450);
		int obstacleHeight4 = SharkGame.HEIGHT - obstacleHeight3 - 150;
		obstacles.add(new Obstacle(x, 0, 50, obstacleHeight3));
		obstacles.add(new Obstacle(x, SharkGame.HEIGHT - obstacleHeight4, 50, obstacleHeight4));

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

	public void purgeObjects() {
		for (int i = 0; i < obstacles.size(); i++) {
			if (obstacles.get(i).isActive == false) {
				obstacles.remove(i);
			}

		}

	}

	public void startGame() {
		framedraw = new Timer(1000 / 60, this);
		framedraw.start();

	}

	void updateGameState() {
		fish.update();
		rod.update();
		shark.update();
		if (fish.isActive == false) {
			currentState = END;

		}
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).update();

		}

		score = score + 0.05;
		checkCollision();
		bullet.update();
		if (bullet.isActive==false) {
			bulletWidth=bulletWidth+8;
			bulletHeight=bulletHeight+4;
			bullet = new Bullets(20, shark.y+75, bulletWidth, bulletHeight, 4);
			

		}
	}

	void updateEndState() {

	}

	@Override
	public void paintComponent(Graphics g) {

		if (currentState == GAME) {
			drawGameState(g);

		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	void drawGameState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, SharkGame.WIDTH, SharkGame.HEIGHT, null);
			fish.draw(g);
			bullet.draw(g);
			shark.draw(g);
			rod.draw(g);
			

		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, SharkGame.WIDTH, SharkGame.HEIGHT);

		}
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).draw(g);
		}
		g.drawString( "Your score is " + (int)(score), 250, 10);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, SharkGame.WIDTH, SharkGame.HEIGHT);

		g.setColor(Color.BLACK);
		g.drawString("SharkGame", 0, 50);

		g.setColor(Color.BLACK);
		g.drawString("You got a score of " + (int)(score), 0, 100);

		g.drawString("Try to avoid the fishing rods", 0, 150);

		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to play again", 0, 125);

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

			fish.up = true;

		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("DOWN");

			fish.down = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("LEFT");

			fish.left = true;

		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("RIGHT");

			fish.right = true;

		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.out.println("Restart");
			currentState = GAME;
			fish.isActive = true;
			fish = new Fish(200, 350, 50, 50, 3);
			score = 0;

		}

	}

	public void checkCollision() {

		for (int o = 0; o < obstacles.size(); o++) {
			if (fish.collisionBox.intersects(obstacles.get(o).collisionBox)) {
				fish.isActive = false;
				System.out.println("After collision");
				currentState = END;
				createObstacles();
				shark.y=0;

			} else if (fish.collisionBox.intersects(rod.collisionBox)) {
				fish.isActive = false;
				System.out.println("After collision");
				currentState = END;
				createFishingRod();
				shark.y=0;

			} else if (fish.collisionBox.intersects(bullet.collisionBox)) {
				fish.isActive = false;
				bulletWidth=40;
				bulletHeight=15;
				bullet = new Bullets(20, shark.y+75, bulletWidth, bulletHeight, 4);
			shark.y=0;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("UP");

			fish.up = false;

		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("DOWN");

			fish.down = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("LEFT");

			fish.left = false;

		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("RIGHT");

			fish.right = false;

		}
	}

}

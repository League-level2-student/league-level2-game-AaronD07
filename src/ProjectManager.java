import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
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
	Obstacle obstacle;
	Obstacle obstacle2;
	int currentState = GAME;

	public ProjectManager() {
		Random random = new Random();
		loadImage("Background.jpg");
		fish = new Fish(200, 350, 50, 50, 1);
		shark = new Shark(5, 300, 150, 150, 1);
		obstacle = new Obstacle(random.nextInt(600), 0, 50, random.nextInt(450));
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
		framedraw = new Timer(1000, this);
		framedraw.start();
		

	}

	void updateGameState() {
		if (fish.isActive == false) {
			currentState = END;

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
			shark.draw(g);
			obstacle.draw(g);
	System.out.println("After Draw image");

		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, WIDTH, HEIGHT);
System.out.println("After draw rectangle");
		}
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.BLACK);
		g.drawString("LEAGUE INVADERS", 0, 50);

		g.setColor(Color.BLACK);
		g.drawString("You got a score of " + 0, 400, END);

		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to start", 0, 600);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (currentState == GAME) {

			updateGameState();
		} else if (currentState == END) {
			updateEndState();

		}
		System.out.println("action");
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}

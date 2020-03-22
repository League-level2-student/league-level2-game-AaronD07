import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Fish extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	public boolean isActive=true;
	
	public Fish(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);
		loadImage("fish.jpg");
	
	}
	   public void draw(Graphics g) {
		    g.setColor(Color.BLUE);
		    g.fillRect(20, 50, 50, 50);

		if (gotImage) {
			g.drawImage(image, 200, 350, 50, 50, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(200, 350, 50, 50);
			System.out.println();
		}
		
	if (needImage) {
	    loadImage ("Fish.png");
	    if (gotImage) {
	    	g.drawImage(image, 0, 0, 800, 600, null);
	    }
	    else {
	    	g.setColor(Color.BLUE);
	    	g.fillRect(0, 0, 800, 600);
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
	    public void right() {
	        x+=speed;
	    }
	    public void left() {
	        x-=speed;
	    }
	    public void up() {
	        y-=speed;
	    }
	    public void down() {
	        y+=speed;
	    }
	 
}

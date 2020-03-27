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
		    g.fillRect(x, y, width, height);

		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
			System.out.println();
		}
		
	if (needImage) {
	    loadImage ("Fish.png");
	    if (gotImage) {
	    	g.drawImage(image, x, y, width, height, null);
	    }
	    else {
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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Shark extends GameObject{
	public Shark(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);
		// TODO Auto-generated constructor stub
	}

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
		   public void draw(Graphics g) {
			    g.setColor(Color.BLUE);
			    g.fillRect(5, 300, 200, 200);

			if (gotImage) {
				g.drawImage(image, 5, 300, 150, 150, null);
			} else {
				g.setColor(Color.BLUE);
				g.fillRect(5, 50, 150, 150);
				System.out.println();
			}
			
		if (needImage) {
		    loadImage ("Shark.jpg");
		    if (gotImage) {
		    	g.drawImage(image, 0, 0, 800, 600, null);
		    }
		    else {
		    	g.setColor(Color.BLUE);
		    	g.fillRect(0, 0, 800, 600);
		    }
		}
		   
		
	if (needImage) {
	    loadImage ("Shark.jpg");
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
	 
}


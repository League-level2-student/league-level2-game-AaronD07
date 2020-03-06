import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Fish {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
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
	    public void draw(Graphics g) {
	    	
	}
}

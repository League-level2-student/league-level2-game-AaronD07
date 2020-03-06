
public class Fish {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	if (needImage) {
	    loadImage ("Fish.png");
	    if (gotImage) {
	    	g.drawImage(image, x, y, width, height, null);
	    } else {
	    	g.setColor(Color.BLUE);
	    	g.fillRect(x, y, width, height);
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
	}
}

import javax.swing.JFrame;

public class SharkGame {
	ProjectManager manager;
JFrame frame;
public static final int WIDTH = 600;
public static final int HEIGHT = 800;
	public static void main(String[] args) {
		SharkGame game = new SharkGame();
game.setup();
	}
	
	public SharkGame () {
		manager = new ProjectManager();
		frame = new JFrame();
		frame.addKeyListener(manager);
	}
	
	public void setup() {
		frame.add(manager);
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

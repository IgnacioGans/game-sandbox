import javax.swing.JFrame;

public class Game extends JFrame {
	public Game() {
		add(new Board());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300);
		setLocationRelativeTo(null);
		setTitle("Pong");
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Game();
	}
}

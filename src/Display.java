import javax.swing.JFrame;


public class Display extends JFrame {

	
	public static void main(String[] args) {
		new Display(new Scene2());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Display(Level l) {
		super("Game");
		setSize(600,450);
		setResizable(false);
		add(l);
		setVisible(true);
		
	}
	
	
	
}

package game12;

import javax.swing.JFrame;

public class GameStart extends JFrame {
	
	public GameStart() {
		setTitle("rpg Game");
		
		MainPanel mainPanel = new MainPanel();
		setContentPane(mainPanel);
		
		setLocationRelativeTo(null);
		
		pack();
		
		
	}
	
	public static void main(String[] arg) {
		
		GameStart gamestart = new GameStart();
		gamestart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamestart.setVisible(true);
	}

}

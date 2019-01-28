package game;

import javax.swing.JPanel;

public class MainPanel extends JPanel  {

    
	private MidiEngine midiEngine = new MidiEngine();
	
	private static final String[] bgmNames = {"castle", "field"};
	
	
	public MainPanel() {
		
		loadSound();
		midiEngine.play("castle");
		
	}

	private void loadSound() {
		
		for(int i = 0; i < bgmNames.length; i++) {
			midiEngine.load(bgmNames[i], "../bgm/" + bgmNames[i] + ".mid");
		}
		
	}

	
}

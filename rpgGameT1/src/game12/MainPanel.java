package game12;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.JPanel;

public class MainPanel extends JPanel implements Runnable, Common {
    
	public static final int WIDTH = 640;
    public static final int HEIGHT = 640;
    
	private MidiEngine midiEngine = new MidiEngine();
	
	private static final String[] bgmNames = {"castle", "field"};
	
	
	private Thread gameLoop;
	
	private Image dbImage = null;
	private Graphics dbg;
	
	private Map[] maps;
	private int mapNo;
	
    private Character hero;
    
    private MessageWindow messageWindow;
    private static Rectangle WND_RECT = new Rectangle(142, 480, 356, 140);
    
    private static final boolean DEBUG_MODE = true;
	
	public MainPanel() {
		
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		/*
		loadSound();
		midiEngine.play("castle");
		*/
		
		maps = new Map[2];
        maps[0] = new Map("../map/castle.map", "../event/castle.evt", "castle", this);
        
        maps[1] = new Map("../map/field.map", "../event/field.evt", "field", this);
        mapNo = 0;  // initial map
        
        hero = new Character(6, 6, 0, DOWN, 0, maps[mapNo]);
        
        messageWindow = new MessageWindow(WND_RECT);
		
		gameLoop = new Thread(this);
		gameLoop.start();
		
		
	}

	private void loadSound() {
		
		for(int i = 0; i < bgmNames.length; i++) {
			midiEngine.load(bgmNames[i], "../bgm/" + bgmNames[i] + ".mid");
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
        long beforeTime, timeDiff, sleepTime;

        beforeTime = System.currentTimeMillis();
        while (true) {

            gameRender();
            printScreen();
        }

        
        
	}

  
	
	
    private void gameRender() {
        if (dbImage == null) {
            // buffer image
            dbImage = createImage(WIDTH, HEIGHT);
            if (dbImage == null) {
                return;
            } else {
                // device context of buffer image
                dbg = dbImage.getGraphics();
            }
        }

        dbg.setColor(Color.WHITE);
        dbg.fillRect(0, 0, WIDTH, HEIGHT);

        // calculate offset so that the hero is in the center of a screen.
        
		/*
		 * System.out.println("hero.getPX():" + hero.getPX());
		 * System.out.println("MainPanel.WIDTH:" + MainPanel.WIDTH);
		 */
        int offsetX = hero.getPX() - MainPanel.WIDTH / 2;
        // do not scroll at the edge of the map
        if (offsetX < 0) {
            offsetX = 0;
        } else if (offsetX > maps[mapNo].getWidth() - MainPanel.WIDTH) {
            offsetX = maps[mapNo].getWidth() - MainPanel.WIDTH;
        }

        int offsetY = hero.getPY() - MainPanel.HEIGHT / 2;
        // do not scroll at the edge of the map
        if (offsetY < 0) {
            offsetY = 0;
        } else if (offsetY > maps[mapNo].getHeight() - MainPanel.HEIGHT) {
            offsetY = maps[mapNo].getHeight() - MainPanel.HEIGHT;
        }

        // draw map
        maps[mapNo].draw(dbg, offsetX, offsetY);

        // draw message window
        messageWindow.draw(dbg);

        // display debug information
        if (DEBUG_MODE) {
            Font font = new Font("SansSerif", Font.BOLD, 16);
            dbg.setFont(font);
            dbg.setColor(Color.YELLOW);
            dbg.drawString(maps[mapNo].getMapName() + " (" + maps[mapNo].getCol() + "," + maps[mapNo].getRow() + ")", 4, 16);
            dbg.drawString("(" + hero.getX() + "," + hero.getY() + ") ", 4, 32);
            dbg.drawString("(" + hero.getPX() + "," + hero.getPY() + ")", 4, 48);
            dbg.drawString(maps[mapNo].getBgmName(), 4, 64);
        }
    }

    
    private void printScreen() {
        Graphics g = getGraphics();
        if ((g != null) && (dbImage != null)) {
            g.drawImage(dbImage, 0, 0, null);
        }
        Toolkit.getDefaultToolkit().sync();
        if (g != null) {
            g.dispose();
        }
    }
  
}

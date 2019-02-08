package textRPG;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Window extends JFrame implements KeyListener {
	
	int GAMESTAGE = 0;
	int GAMESTEP = 0;	
	
	
	JPanel mainPanel, monsterPanel, heroPanel;
	static JLabel monster1, monster2, monster3, monsterking;
	static JLabel mapDisplay;
	static JLabel explainDisplay;
	static JLabel heroHP, distance;
	JTextField inputDisplay;
	
	MapWindow mapWin = new MapWindow();
	
	Hero hero;
	Monster mons1, mons2, mons3, monsKING, nowMon;
	
	public Window() {
		setTitle("textRPG");
		setSize(500, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new JPanel();
		mainPanel.setBorder(new TitledBorder("test1"));
		mainPanel.setLayout(null);
		mainPanel.setLocation(0, 0);
		
		monsterPanel = new JPanel();
		monsterPanel.setBorder(new TitledBorder("test2"));
		monsterPanel.setLayout(null);
		monsterPanel.setSize(500, 200);
		monsterPanel.setLocation(0, 20);
		
		monster1 = new JLabel();
		monster1.setBorder(new TitledBorder("monster1"));
		monster1.setText("");
		monster1.setSize(120, 160);
		monster1.setLocation(0, 30);
		
		monsterPanel.add(monster1);
		
		monster2 = new JLabel();
		monster2.setBorder(new TitledBorder("monster2"));
		monster2.setText("");
		monster2.setSize(120, 160);
		monster2.setLocation(121, 30);
		
		monsterPanel.add(monster2);
		
		monster3 = new JLabel();
		monster3.setBorder(new TitledBorder("monster3"));
		monster3.setText("");
		monster3.setSize(120, 160);
		monster3.setLocation(241, 30);
		
		monsterPanel.add(monster3);
		
		monsterking = new JLabel();
		monsterking.setBorder(new TitledBorder("monsterking"));
		monsterking.setText("");
		monsterking.setSize(120, 160);
		monsterking.setLocation(361, 30);
		
		monsterPanel.add(monsterking);
		
		mainPanel.add(monsterPanel);
		
		heroPanel = new JPanel();
		heroPanel.setBorder(new TitledBorder("test3"));
		heroPanel.setLayout(null);
		heroPanel.setSize(500, 400);
		heroPanel.setLocation(0, 220);
		
		mapDisplay = new JLabel();
		mapDisplay.setBorder(new TitledBorder("map"));
		//mapDisplay.setText("<html>***H*******************<br>*********M*************</html>");
		mapDisplay.setSize(200, 200);
		mapDisplay.setLocation(0, 30);
		
		heroPanel.add(mapDisplay);
		
				
		heroHP = new JLabel();
		heroHP.setBorder(new TitledBorder("heroHP"));
		heroHP.setText("");
		heroHP.setSize(100, 100);
		heroHP.setLocation(201, 30);
		//explainDisplay.addKeyListener(this);
		
		heroPanel.add(heroHP);

		distance = new JLabel();
		distance.setBorder(new TitledBorder("distance"));
		distance.setText("");
		distance.setSize(100, 100);
		distance.setLocation(301, 30);
		//explainDisplay.addKeyListener(this);
		
		heroPanel.add(distance);
		
		explainDisplay = new JLabel();
		explainDisplay.setBorder(new TitledBorder("explainDisplay"));
		explainDisplay.setText("game start");
		explainDisplay.setSize(200, 200);
		explainDisplay.setLocation(201, 130);
		//explainDisplay.addKeyListener(this);
		
		heroPanel.add(explainDisplay);
		
		
		inputDisplay = new JTextField();
		inputDisplay.setBorder(new TitledBorder("inputDisplay"));
		
		inputDisplay.setSize(200, 50);
		inputDisplay.setLocation(0, 230);
		inputDisplay.addKeyListener(this);
		
		heroPanel.add(inputDisplay);
		
		
		

		mainPanel.add(heroPanel);
		
		getContentPane().add(mainPanel, null);
		
		setVisible(true);
		
		explainDisplay.setText(Sentence.EX_1);
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char key = e.getKeyChar();
		int keyNum = (int)key;
		int keyN = e.getKeyCode();
		
		System.out.println("key ::" + key + " keyNum ::" + keyNum + " keyN ::" + keyN);
		
		//mapDisplay.setText(mapWin.setMap());
		
		gameEvent(keyN);
		

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void gameEvent(int keyN) {
		System.out.println("GAMESTAGE::" + GAMESTAGE + "GAMESTEP::" + GAMESTEP);

		
		
		if(GAMESTAGE == 0 && GAMESTEP == 0 && keyN == 10) {
			System.out.println(2);

			hero = new Hero(inputDisplay.getText());
			mons1 = new Monster("monster1", 50, 1, 10, 15, 2, 2);
			mapDisplay.setText(mapWin.setIni());
			
			mapWin.setHP(hero, mons1) ;
			
			explainDisplay.setText(Sentence.EX_2);
			
			GAMESTEP = 1;
			GAMESTAGE = 1;
			nowMon = mons1;
			
			inputDisplay.setEditable(false);
			inputDisplay.setText("");
			
		}else if(GAMESTAGE == 1 && keyN == 37) {
			System.out.println("hero.getX()::" + hero.getX() + "hero.getY()::" + hero.getY());
			if(hero.getX() != 1) {				
				hero.setX(hero.getX() - 1);
				mons1.autoMoving();
				System.out.println("hero.getX()::" + hero.getX() + "hero.getY()::" + hero.getY());
				mapWin.mapEvent(hero,mons1,Sentence.EVENTMODE_MOVE);
			}else {
				
			}
			nowMon = mons1;
			
		}else if(GAMESTAGE == 1 && keyN == 38) {
			if(hero.getY() != 1) {				
				hero.setY(hero.getY() - 1);
				mons1.autoMoving();
				mapWin.mapEvent(hero,mons1,Sentence.EVENTMODE_MOVE);
			}else {
				
			}
			nowMon = mons1;
		}else if(GAMESTAGE == 1 && keyN == 39) {
			if(hero.getX() != 30) {				
				hero.setX(hero.getX() + 1);
				mons1.autoMoving();
				mapWin.mapEvent(hero,mons1,Sentence.EVENTMODE_MOVE);
			}else {
				
			}
			nowMon = mons1;
		}else if(GAMESTAGE == 1 && keyN == 40) {
			if(hero.getY() != 10) {				
				hero.setY(hero.getY() + 1);
				mons1.autoMoving();
				mapWin.mapEvent(hero,mons1,Sentence.EVENTMODE_MOVE);
			}else {
				
			}
			nowMon = mons1;
		}
		
		
		if(GAMESTAGE >= 1 && keyN == 65) {
			mons1.autoMoving();
			mapWin.mapEvent(hero,mons1,Sentence.EVENTMODE_ATTACK);
		}else if(GAMESTAGE >= 1 && keyN == 83) {
			mons1.autoMoving();
			mapWin.mapEvent(hero,mons1,Sentence.EVENTMODE_ATTACK2);
		}
		
		if(GAMESTAGE != 0) {
			distance.setText(Integer.toString(mapWin.distance(hero, nowMon)));
		}
	}
	
	public void mapMoving(int keyN) {
		
		
	}
	
}

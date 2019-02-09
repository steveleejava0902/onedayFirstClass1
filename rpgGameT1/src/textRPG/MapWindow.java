package textRPG;

public class MapWindow {
	
	String mapXY = "<html>";
	String monsterText ; 
	String heroText ;
	String explainText ;
	
	public String setIni() {

		
		for(int mapY = 1; mapY <=10; mapY++) {
			
		
			
			for(int mapX = 1; mapX <=30; mapX++) {
				
				if(mapX == 15 && mapY == 9) {
					mapXY = mapXY + "H";
					
				}else if(mapX == 15 && mapY == 2) {
					mapXY = mapXY + "M";
					
				}else {
					mapXY = mapXY + "*";
				}
			}
		
			mapXY = mapXY + "<br>";
			
		}
		
		mapXY = mapXY + "</html>";
		
		return mapXY;
		
	}
	
	public void mapEvent(Hero hero, Monster mons, int mode) {
		
		setMoving(hero, mons);
		battle(hero, mons, mode);
		
	}

	public void setMoving(Hero hero, Monster mons) {

		mapXY = "<html>";
		
		System.out.println("hero.getX()::" + hero.getX() + "hero.getY()::" + hero.getY());
		
		for(int mapY = 1; mapY <=10; mapY++) {
			
		
			
			for(int mapX = 1; mapX <=30; mapX++) {
				
				if(hero.getX() == mapX && hero.getY() == mapY) {
					mapXY = mapXY + "H";
				}else if(mons.getX() == mapX && mons.getY() == mapY) {
					mapXY = mapXY + "M";
				
				}else {
					mapXY = mapXY + "*";
				}
			}
		
			mapXY = mapXY + "<br>";
			
		}
		
		mapXY = mapXY + "</html>";
		
		
		
		
		
		Window.mapDisplay.setText(mapXY);
		
		
	}
	
	public void setHP(Hero hero, Monster mons) {
		
		monsterText = "<html>hp:" + mons.getHp()
		+ "<br> </html>";

		heroText = "<html>hp:" + hero.getHp()
		+ "<br> </html>";
		
		Window.monster1.setText(monsterText);
		Window.heroHP.setText(heroText);
		
	}
	
	
	public void battle(Hero hero, Monster mon, int mode) {
		
		System.out.println("battle");
		
		if(mode == 0) {
			
			int dis = distance(hero, mon);
			
			if(dis <= mon.getAttackDistance()) {
				mon.attack(hero);
				System.out.println("attack");
			}
			
			
		}else if(mode == 1) {
			int dis = distance(hero, mon);
			
			if(dis <= mon.getAttackDistance()) {
				mon.attack(hero);
				System.out.println("attack");
			}
			
			
			if(dis <= hero.getA_distance()) {
				hero.attack(mon);
				System.out.println("attackA");
				Window.explainDisplay.setText("원거리 공격이 성공하였습니다.");
			}else {
				Window.explainDisplay.setText("원거리 공격이 실패하였습니다.");
			}
			
		}else if(mode == 2) {
			int dis = distance(hero, mon);
			
			if(dis <= mon.getAttackDistance()) {
				mon.attack(hero);
				System.out.println("attack");
			}
			
			
			if(dis <= hero.getS_distance()) {
				hero.attack2(mon);
				System.out.println("attackS");
				Window.explainDisplay.setText("근거리 공격이 성공하였습니다.");
			}else {
				Window.explainDisplay.setText("근거리 공격이 실패하였습니다.");
			}
			
		}
		
		setHP(hero, mon) ;
		
	}
	
	public void checkMonHP() {
		
	}
	
	
	public int distance(Hero hero, Monster mon) {
		
		int hx = hero.getX();
		int hy = hero.getY();
		int mx = mon.getX();
		int my = mon.getY();
		
		int dx = Math.abs(hx - mx);
		int dy = Math.abs(hy - my);
		
		return dx + dy;
		
		
		
	}
	
	
	public String setMap() {
		
		
		
		int cnt = 1 ;
		
		for(int mapX = 1; mapX <=10; mapX++) {
			
			cnt = (int)(Math.random() * 30) + 1;
			
			for(int mapY = 1; mapY <=30; mapY++) {
				
				if(cnt == mapY) {
					mapXY = mapXY + "H";
				}else {
					mapXY = mapXY + "*";
				}
			}
		
			mapXY = mapXY + "<br>";
			
		}
		
		mapXY = mapXY + "</html>";
		
		return mapXY;
		
	}

}

package textRPG;

public class MapWindow {
	
	String mapXY = "<html>";
	String monsterText ; 
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
		
		monsterText = "<html>hp:" + mons.getHp()
				+ "<br> </html>";
		
		explainText = "<html>hp:" + hero.getHp()
		+ "<br> </html>";
		
		Window.monster1.setText(monsterText);
		Window.explainDisplay.setText(explainText);
		
		Window.mapDisplay.setText(mapXY);
		
		
	}
	
	
	public void battle(CharacterReal hero, CharacterReal mon, int mode) {
		
		if(mode == 0) {
			
			
		}
		
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

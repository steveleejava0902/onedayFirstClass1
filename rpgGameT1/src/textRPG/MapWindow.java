package textRPG;

public class MapWindow {
	
	
	public String setMap() {
		
		
		String mapXY = "<html>";
		
		int cnt = 1 ;
		
		for(int mapX = 1; mapX <=12; mapX++) {
			
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

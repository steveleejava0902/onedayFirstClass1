package textRPG;

public class Monster extends CharacterReal implements Character {

	private int attackDistance;

	public int getAttackDistance() {
		return attackDistance;
	}

	public void setAttackDistance(int attackDistance) {
		this.attackDistance = attackDistance;
	}

	public Monster(String name, int hp, int level, int attack_p, int x, int y, int attackDistance) {
		super(name, hp, level, attack_p, x, y);
		this.attackDistance = attackDistance;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack(CharacterReal real) {
		// TODO Auto-generated method stub
		
		int hp = real.getHp();
		hp = hp - this.getAttack_p();	
		real.setHp(hp);
		
	}

	@Override
	public void move(CharacterReal real) {
		// TODO Auto-generated method stub
		
	}

	
	public void autoMoving() {
		
		int xy = (int)(Math.random() * 2) + 1;
		int sign = (int)(Math.random() * 2) + 1;
		int moving = (int)(Math.random() * 2) + 1;
		
		int x = getX();
		int y = getY();
		
		//x축이동
		if(xy == 1) {
			
			//플러스 이동
			if((sign == 1 && x == 30) || (sign == 1 && x == 29 && moving == 2)) {
				
				
			}else if((sign == 2 && x == 1) || (sign == 2 && x == 2 && moving == 2)) {
				
			}else if(sign == 1) {
				setX(x + moving);
			}else {
				setX(x - moving);
			}
		
			
		//y축이동
		}else {
			
			//플러스 이동
			if((sign == 1 && y == 10) || (sign == 1 && y == 9 && moving == 2)) {
				
				
			}else if((sign == 2 && y == 1) || (sign == 2 && y == 2 && moving == 2)) {
				
			}else if(sign == 1) {
				setY(y + moving);
			}else {
				setY(y - moving);
			}
			
		}
		
		
	}

}

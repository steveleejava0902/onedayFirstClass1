package textRPG;

public class Hero extends CharacterReal implements Character {

	public Hero(String name) {
		super(name, 50, 1, 3, 15, 9);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack(CharacterReal real) {
		// TODO Auto-generated method stub
		
		int hp = real.getHp();
		hp = hp - this.getAttack_p();		
		
	}

	@Override
	public void move(CharacterReal real) {
		// TODO Auto-generated method stub
		
	}


}

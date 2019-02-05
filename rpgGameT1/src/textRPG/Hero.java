package textRPG;

public class Hero extends CharacterReal implements Character {

	public Hero(String name, int hp, int level, int attack_p) {
		super(name, hp, level, attack_p);
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

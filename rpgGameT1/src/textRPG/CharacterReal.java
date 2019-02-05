package textRPG;

public class CharacterReal {
	
	private String name;
	
	private int hp;
	private int level;
	private int attack_p;
	
	public CharacterReal(String name, int hp, int level, int attack_p) {
		super();
		this.name = name;
		this.hp = hp;
		this.level = level;
		this.attack_p = attack_p;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getAttack_p() {
		return attack_p;
	}

	public void setAttack_p(int attack_p) {
		this.attack_p = attack_p;
	}
	
	
	

}

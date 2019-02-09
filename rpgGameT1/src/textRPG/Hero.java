package textRPG;

public class Hero extends CharacterReal implements Character {

	
	
	private int a_distance = 6;
	private int s_distance = 3;
	private int a_attackP ;
	private int s_attackP ;
	
	public Hero(String name) {
		super(name, 50, 1, 3, 15, 9);
		// TODO Auto-generated constructor stub
		
		a_attackP = super.getAttack_p();
		s_attackP = super.getAttack_p() * 2;
	}

	
	
	public int getA_distance() {
		return a_distance;
	}



	public void setA_distance(int a_distance) {
		this.a_distance = a_distance;
	}



	public int getS_distance() {
		return s_distance;
	}



	public void setS_distance(int s_distance) {
		this.s_distance = s_distance;
	}



	public int getA_attackP() {
		return a_attackP;
	}



	public void setA_attackP(int a_attackP) {
		this.a_attackP = a_attackP;
	}



	public int getS_attackP() {
		return s_attackP;
	}



	public void setS_attackP(int s_attackP) {
		this.s_attackP = s_attackP;
	}



	@Override
	public void attack(CharacterReal real) {
		// TODO Auto-generated method stub
		
		int hp = real.getHp();
		hp = hp - this.getA_attackP();	
		
		real.setHp(hp);
		
	}
	
	public void attack2(CharacterReal real) {
		// TODO Auto-generated method stub
		
		int hp = real.getHp();
		System.out.println("this.getS_attackP()::" + this.getS_attackP());
		hp = hp - this.getS_attackP();		
		real.setHp(hp);
	}

	@Override
	public void move(CharacterReal real) {
		// TODO Auto-generated method stub
		
	}


}

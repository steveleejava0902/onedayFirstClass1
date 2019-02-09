package textRPG;

public class Sentence {
	
	static String EX_1 = "<HTML>안녕하세요 textRPG에 오신것을 환영합니다"
						+ "<br>몬스터들로 마을을 구하시고 우리에 왕이되어주세요"
						+ "<BR>입력창에 이름을 입력하시고 엔터키를 누르시면"
						+ "<BR>게임이 시작됩니다."
						+ "</HTML>";
	
	static String EX_2 = "<HTML>몬스터가 출현했습니다"
			+ "<br>방향키로 이동하시거나"
			+ "<BR>a 버튼으로 원거리공격(거리6)"
			+ "<BR>s 버튼으로 근거리공격(거리3)."
			+ "하시오.</HTML>";
	
	static int EVENTMODE_MOVE = 0;
	static int EVENTMODE_ATTACK = 1;
	static int EVENTMODE_ATTACK2 = 2;

}

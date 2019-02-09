package latte568;

public class Question2 {

	public void arrPrint(int c)
	{
		int [] a = new int[c];
		
		for(int i = 1 ; i <= c ; i ++)
		{
			a[i-1] = i;
			System.out.println("a["+ (i-1) +"] = "+ i);
		}
	}
	
	public static void main(String[] args) {
		
		Question2 calc = new Question2();
		calc.arrPrint(5);
	}

}

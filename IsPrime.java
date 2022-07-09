package week1.day1;

public class IsPrime {

	public static void main(String[] args) {
		
		int n = 20;
		int c = 0;
		int i;
		
		for(i = 2; i < n; i++)
		{
			if( n%i == 0)
			{
				c = 1;
				break;
			}
		}
			
		if(c==1)
		{
			System.out.println(n+" is not a Prime number.");
		}
		else
		{
			System.out.println(n+" is a Prime number.");
		}
	}

}

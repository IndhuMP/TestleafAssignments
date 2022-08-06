package testleaf.programs;

public class HappyNumber {
	
	public static int digit_sq(int num)
	{
		int sum=0,r;
		int n = num;
		
		while(n>0)
		{
			r = n % 10;
			n = n / 10;
			sum = sum + (r*r);
		}
		return sum;
	}

	public static void main(String[] args) {

		int number = 2;
		
		while(number != 1)
		{
			System.out.println(number);
			number = digit_sq(number);		
		}
		System.out.println("Happy no");
		
		

	}

}

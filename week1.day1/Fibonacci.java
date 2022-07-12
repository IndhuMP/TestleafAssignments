package week1.day1;

public class Fibonacci {

	public static void main(String[] args) {
		int a=0, b=1, sum = 0;
		
		for(int j =1; j<11;j++)
		{
			sum = a + b;
			b = a;
			a = sum;
			System.out.println(sum);
		}

	}

}

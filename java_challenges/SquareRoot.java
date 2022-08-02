package testleaf.programs;

public class SquareRoot {

	public static void main(String[] args) {
		
		int num = 625;
		int ans = 1;
		int i = 1;
		
		while (ans <= num) {
            i++;
            ans = i * i;
        }
		System.out.println(i-1);

	}

}

package week1.optional;


public class MyCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator cal = new Calculator();
		
		int sum;
		int diff;
		double pdt;
		float result;
		
		int num1=20, num2=10, num3=5;
		double a = 3322, b=332;
		float c=2.4f, d=1.2f;
		
		sum = cal.add(num1, num2, num3);
		diff = cal.sub(num1, num2);
		pdt = cal.mul(a, b);
		result = cal.divide(c, d);
		
		
		System.out.println(sum);
		System.out.println(diff);
		System.out.println(pdt);
		System.out.println(result);
		

	}

}

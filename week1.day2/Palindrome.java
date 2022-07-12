package week1.day2;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "madam";
		
		char[] ch1 = str.toCharArray();
		char[] ch2 = new char[ch1.length];
		int i,j=0;
		boolean c=true;
		
		for(i=ch1.length-1; i>=0; i--)
		{
			ch2[j] = ch1[i];
			j++;
		}
		for(i=0; i<ch1.length; i++)
		{
			if(ch1[i] != ch2[i])
			{
				c = false;
				System.out.println("Not Palindrome");
				break;
			}
		}
		
		if(c)
		{
			System.out.println("Palindrome");
		}

	}

}

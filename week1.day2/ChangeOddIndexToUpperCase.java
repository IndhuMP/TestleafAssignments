package week1.day2;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "changeme";
		int i;
		char[] ch = str.toCharArray();
		
		for(i=0; i<ch.length; i++)
		{
			if(i%2 != 0)
			{
				char ch1 = Character.toUpperCase(ch[i]);
				ch[i] = ch1;
			}
		}
		
		System.out.println(String.valueOf(ch));

	}

}

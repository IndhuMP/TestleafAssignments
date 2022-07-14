package week1.day2;

import java.util.Arrays;

public class IsAnagram {

	public static void main(String[] args) {
		
		String str1 = "hello";
		String str2 = "eolhh";
		boolean bAnagram = true;
		
		char[] chr1=str1.toCharArray();
		char[] chr2 =str2.toCharArray();
		
		Arrays.sort(chr1);
		Arrays.sort(chr2);
		
		for(int i=0;i<chr1.length;i++)
		{
			if(chr1[i] != chr2[i])
			{
				bAnagram = false;
				//System.out.println("Not Anagram");
				break;
			}
		}
			if(bAnagram) {
				System.out.println("It is anagram");
			}
			else {
				System.out.println("Not Anagram");
			}
		

	}

}

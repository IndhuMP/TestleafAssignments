package week1.day2;

public class ReverseEvenWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "This is a string reverse.";
		String[] input_words = input.split(" ");
		//System.out.println(input_words.toString());
		int l =input_words.length;
		
		String sec_word = new String();
		for(int i=0; i<l; i++)
		{
			if(i%2 != 0)
			{
				String rev_str = input_words[i];
				char[] ch=rev_str.toCharArray();
				
				char[] ch1=new char[ch.length];
				int m =0;
				
				for(int j=ch.length-1; j>=0; j--)
				{					
					
					ch1[m] = ch[j];
					m++;
				}
				sec_word = String.valueOf(ch1);
				input_words[i] = sec_word;
			}
			else
			{
				continue;
			}
		}
			
		for(int i =0; i<input_words.length; i++)
		{
			System.out.print(input_words[i]+" ");
		}

	}

}

package week1.day2;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "We learn java basics as part of java sessions in java week1";
		int i, j;
		
		String[] words = text.split(" ");
		
		for(i=0; i<words.length; i++)
		{
			for(j=i+1; j<words.length; j++)
			{
				if(words[i].equalsIgnoreCase(words[j]))
				{
					words[i] = " ";
				}
				else
				{
					continue;
				}
			}
		}
		for(i=0; i<words.length; i++)
		{
			System.out.print(words[i]+" ");
		}
	}

}

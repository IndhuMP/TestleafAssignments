package testleaf.programs;

public class LengthOfLastWord {

	public static void main(String[] args) {


		String str = "   fly me   to   the moon  ";
		//String str = "Hello World";
		//String str = = "luffy is still joyboy";
		
		String words[] = str.split(" ");
		
		int len = words.length;
		
		String last = words[len-1];
		
		System.out.println(last.length());

	}

}

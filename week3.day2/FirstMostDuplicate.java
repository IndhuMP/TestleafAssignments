package week3.day2.assignment;

import java.util.*;

public class FirstMostDuplicate {

	public static void main(String[] args) {

		//take an input
		String input = "abbaba";
		
		char[] ch = input.toCharArray();
		char maxOccChar = input.charAt(0);
		
		//create hashmap and put the values of input into it
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		
		//Keep comparing the occurance with other values -> max value -> character
		int maxOccur = 0;
		//initially take the first character and the maxoccur as zero
		for(int i=0; i<ch.length; i++)
		{
			map.put(ch[i], map.getOrDefault(ch[i], 0)+1);
			//if value occurs more than once reassign it
			if(map.get(ch[i]) > maxOccur)
			{
				maxOccur = map.get(ch[i]);
				maxOccChar = ch[i];
			}
		}
		
		//pront the value that occurred most
		System.out.println(maxOccChar);
	}

}

package week3.day2.assignment;

import java.util.*;

public class FindNumberOccurance {

	public static void main(String[] args) {
		
		//Input array numbers, each occurances
		 int[] input= {2,3,5,6,3,2,1,4,2,1,6,-1};
		 
		 //create hashmap and put the values of input into it
		 Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		//add values of array to the map
		 for(int i=0; i<input.length; i++)
		 {
			 map.put(input[i], map.getOrDefault(input[i], 0)+1);

		 }
		
		 //iterate thorugh each print the value and their occurance
		 for(Map.Entry<Integer, Integer> entry:map.entrySet())
		 {
			 System.out.println(entry.getKey()+"-->"+entry.getValue());
		 }

	}

}

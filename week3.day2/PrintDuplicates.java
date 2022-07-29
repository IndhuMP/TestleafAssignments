package week3.day2.assignment;

import java.util.*;

public class PrintDuplicates {

	public static void main(String[] args) {
		
		//take an input array
		int[] arr = {14,12,13,11,15,14,18,16,17,19,18,17,20};
		
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		
		//put the values of array into a map and get the duplicate count
		for(int i=0; i<arr.length; i++)
		{
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		
		//iterate through map
		for(Map.Entry<Integer, Integer> entry:map.entrySet())
		{
			//if value present more than once print them
			if(entry.getValue() > 1)
			{
				System.out.println(entry.getKey());
			}
		}		
			
	}

}

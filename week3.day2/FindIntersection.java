package week3.day2.assignment;

import java.util.*;

public class FindIntersection {

	public static void main(String[] args) {

		
		//Declare An array for {3,2,11,4,6,7};	 
		int[] arr1={3,2,11,4,6,7};
		
		// Declare another array for {1,2,8,4,9,7};
		int[] arr2 = {1,2,8,4,9,7};
		
	    // Declare a set and the array to the set
		List<Integer> list1 = new ArrayList<Integer>();
		
		for(int i=0; i<arr1.length; i++)
		{
			list1.add(arr1[i]);
		}
	    // Declare a list and the array to the set
		List<Integer> list2= new ArrayList<Integer>();
		
		for(int j=0; j<arr2.length; j++)
		{
			list2.add(arr2[j]);
		}
		
		//Compare Both the arrays using a condition statement
		Set<Integer> set = new LinkedHashSet<Integer>();
		for(Integer ans: list1)
		{
			if(list2.indexOf(ans) > -1)
			{
				set.add(ans);
			}
		}
	 
	//Print the first array (shoud match item in both arrays)
	 System.out.println(set);
	}

}

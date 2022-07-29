package week3.day2.assignment;

import java.util.*;

public class MissingElementInArray {

	public static void main(String[] args) {

		// Here is the input
		int[] arr = {1,2,3,4,7,6,8};

		// Sort the array
		List<Integer> lst = new ArrayList<Integer>();
		
		for(int i=0; i<arr.length; i++)
		{
			lst.add(arr[i]);
		}
		Collections.sort(lst);
		
    // loop through the array (start i from arr[0] till the length of the array)
		for(int i=1; i<lst.size(); i++)
		{
      // check if the iterator variable is not equal to the array values respectively
			if(lst.get(i) != i+1)
			{
        // print the number
			  System.out.println(i+1);
			  // once printed break the iteration
        break;
			}
		}	
		
	}

}

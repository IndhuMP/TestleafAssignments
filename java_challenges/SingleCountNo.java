package testleaf.programs;

import java.util.*;

public class SingleCountNo {

	public static void main(String[] args) {
			
		int[] nums = {4,1,2,1,2};
		
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		
		for(int i=0; i<nums.length; i++)
		{
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		for(Map.Entry<Integer, Integer> entry: map.entrySet())
		{
			if(entry.getValue() == 1)
			{
				System.out.println(entry.getKey());
			}
		}

	}

}

package week7;

import java.util.*;

public class prgrms12 {

	static HashMap<Integer, Integer> map = new HashMap<>();
	static int res = 0;

	public int solution(int[] nums) {

		for (int num : nums) {
			if (!map.containsKey(num)) map.put(num, 0);
			map.put(num, map.get(num)+1);
		}

		int count = 0;

		for (int key : map.keySet()) {
			if (count == nums.length/2) return count;
			count++;
		}
		return count;
	}
}

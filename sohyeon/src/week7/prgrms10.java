package week7;

import java.util.*;

public class prgrms10 {
	public int[] solution(int []arr) {

		ArrayList<Integer> al = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (al.size() > 0 && al.get(al.size()-1) == arr[i]) continue;
			al.add(arr[i]);
		}

		int[] answer = new int[al.size()];
		for (int i = 0; i < al.size(); i++) {
			answer[i] = al.get(i);
		}

		return answer;
	}
}
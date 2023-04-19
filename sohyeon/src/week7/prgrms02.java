package week7;

import java.util.*;

public class prgrms02 {
	public int[] solution(int[] numbers) {

		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i; j < numbers.length; j++) {
				if (i == j) continue;
				int res = numbers[i] + numbers[j];
				if (al.contains(res)) continue;
				al.add(numbers[i] + numbers[j]);
			}
		}

		Collections.sort(al);

		int[] answer = new int[al.size()];
		for (int i = 0; i < al.size(); i++) {
			answer[i] = al.get(i);
		}

		return answer;
	}
}

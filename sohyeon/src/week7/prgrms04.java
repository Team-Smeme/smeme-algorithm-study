package week7;

import java.util.*;

public class prgrms04 {
	public int[] solution(int[][] v) {

		ArrayList<Integer> x = new ArrayList<>();
		ArrayList<Integer> y = new ArrayList<>();

		int[] answer = new int[2];

		for (int i = 0; i < v.length; i++) {
			x.add(v[i][0]);
			y.add(v[i][1]);
		}

		for (int i = 0; i < v.length; i++) {
			if (Collections.frequency(x, v[i][0])==1) answer[0] = v[i][0];
			if (Collections.frequency(y, v[i][1])==1) answer[1] = v[i][1];
		}

		System.out.println("Hello Java");

		return answer;
	}
}

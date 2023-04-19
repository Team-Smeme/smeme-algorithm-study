package week7;

import java.util.*;

public class prgrms01 {
	public int solution(String word) {

		String str = "AEIOU";
		int[] x = new int[5];
		x[4] = 1;
		for (int i = 3; i >= 0; i--) x[i] = x[i+1] * 5 + 1;

		int answer = word.length();
		for (int i = 0; i < word.length(); i++) {
			int index = str.indexOf(word.charAt(i));
			answer += index * x[i];
		}
		return answer;
	}
}

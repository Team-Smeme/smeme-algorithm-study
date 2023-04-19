package week7;

import java.util.*;

public class prgrms05 {

	static int zero = 0;
	static int cnt = 0;

	public int[] solution(String s) {

		int[] answer = new int[2];

		while (s.length() > 1) {
			int cntOne = 0;

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '0') answer[1]++;
				else cntOne++;
			}

			s = transfer(cntOne);
			answer[0]++;
		}

		return answer;
	}

	private String transfer(int len) {
		StringBuilder sb = new StringBuilder();
		while (len != 0) {
			sb.append(len%2);
			len /= 2;
		}
		return sb.reverse().toString();
	}
}

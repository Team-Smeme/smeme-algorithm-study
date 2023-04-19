package week7;

import java.util.*;

public class prgrms03 {
	public int solution(int n, int k) {
		String num = transfer(n, k);

		Queue<Long> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num.length(); i++) {
			if (num.charAt(i) == '0') {
				if (sb.length() == 0) continue;
				queue.add(Long.valueOf(sb.toString()));
				sb.setLength(0);
			} else {
				sb.append(num.charAt(i));
			}
		}

		if (sb.length() != 0) {
			queue.add(Long.valueOf(sb.toString()));
		}

		int answer = 0;
		while (!queue.isEmpty()) {
			Long temp = queue.remove();
			if (isPrime(temp)) answer++;
		}
		return answer;
	}

	private boolean isPrime(Long num) {
		if (num == 1) return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % (long)i == 0) return false;
		}
		return true;
	}

	private String transfer(int n, int k) {
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			sb.append(n%k);
			n /= k;
		}
		return sb.reverse().toString();
	}
}

package week6;

import java.util.*;

public class prgrms7 {
	public long solution(long n) {
		return convert10(convert3(n));
	}

	private long convert10(String num) {
		long res = 0;
		for (int i = 0; i < num.length(); i++) {
			String str = String.valueOf(num.charAt(i));
			res += Long.parseLong(str) * Math.pow(3, num.length()-i-1);
		}
		return res;
	}

	private String convert3(long num) {
		StringBuilder sb = new StringBuilder();
		while (num != 0) {
			sb.append(Long.toString(num%3));
			num /= 3;
		}
		return sb.toString();
	}
}

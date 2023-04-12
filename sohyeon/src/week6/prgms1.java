package week6;

import java.io.*;
import java.util.*;

public class prgms1 {
	public long solution(int price, int money, int count) {
		long answer = getTotal(price, count) - money;
		return answer > 0 ? answer : 0;
	}

	private long getTotal(int price, int count) {
		long total = 0;
		for (int i = 1; i <= count; i++) {
			total += price * i;
		}
		return total;
	}
}

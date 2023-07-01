package week18;

import java.io.*;
import java.util.*;

public class boj2562 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int max = Integer.MIN_VALUE;
		int idx = -1;

		for (int i = 1; i <= 9; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > max) {
				max = num;
				idx = i;
			}
		}

		System.out.println(max);
		System.out.println(idx);
	}
}

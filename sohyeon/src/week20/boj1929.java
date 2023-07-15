package week20;

import java.io.*;
import java.util.*;

public class boj1929 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		for (int i = m; i <= n; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
	}

	private static boolean isPrime(int num) {
		if (num == 1) return false;

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
}

package week24;

import java.io.*;
import java.util.*;

public class boj17626 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		int[] dp = new int[num + 1];
		dp[1] = 1;

		int min;
		for (int i = 2; i <= num; i++) {
			min = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				int temp = i - j * j;
				min = Math.min(min, dp[temp]);
			}
			dp[i] = min + 1;
		}

		System.out.println(dp[num]);

	}
}
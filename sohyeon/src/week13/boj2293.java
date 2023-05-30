package week13;

import java.util.*;
import java.io.*;

public class boj2293 {

	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[] coins = new int[N];
		int[] dp = new int[K + 1];
		dp[0] = 1;

		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		for (int coin : coins) {
			for (int i = 1; i <= K; i++) {
				if (coin > i) continue;
				dp[i] += dp[i - coin];
			}
		}

		System.out.println(dp[K]);
	}
}

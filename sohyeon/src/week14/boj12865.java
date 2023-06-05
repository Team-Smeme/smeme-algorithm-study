package week14;

import java.io.*;
import java.util.*;

public class boj12865 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] dp = new int[n+1][k+1];
		int[][] dummy = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			dummy[i] = new int[] {w, v};
		}

		for (int j = 0; j <= k; j++) {
			for (int i = 1; i <= n; i++) {
				if (j < dummy[i-1][0]) {
					dp[i][j] = dp[i-1][j];
				} else {
					int pre = j - dummy[i-1][0];
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][pre] + dummy[i-1][1]);
				}
			}
		}

		System.out.println(dp[n][k]);
	}
}

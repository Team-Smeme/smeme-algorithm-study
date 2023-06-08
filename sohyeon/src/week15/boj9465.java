package week15;

import java.io.*;
import java.util.*;

public class boj9465 {

	static int N, M;
	static int[][] sticker;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			M = Integer.parseInt(br.readLine());
			sticker = new int[2][M];
			for (int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int i = 0; i < M; i++) sticker[j][i] = Integer.parseInt(st.nextToken());
			}
			System.out.println(getMax());

		}


	}

	private static int getMax() {
		int[][] dp = new int[2][M + 1];
		dp[0][1] = sticker[0][0];
		dp[1][1] = sticker[1][0];
		for (int i = 2; i <= M; i++) {
			dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i - 1];
			dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i - 1];
		}

		// for (int[] arr : dp) {
		// 	System.out.println(Arrays.toString(arr));
		// }

		return Math.max(dp[0][M], dp[1][M]);
	}
}

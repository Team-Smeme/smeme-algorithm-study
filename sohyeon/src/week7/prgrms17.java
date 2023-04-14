package week7;

import java.util.*;

public class prgrms17 {
	int solution(int[][] land) {

		int[][] dp = new int[land.length][4];
		for (int i = 0; i < 4; i++) {
			dp[0][i] = land[0][i];
		}

		for (int i = 1; i < land.length; i++) {
			if (i >= land.length) break;

			for (int j = 0; j < 4; j++) {
				dp[i][j] = land[i][j] + getMax(dp, i-1, j);
			}
		}

		int answer = 0;

		for (int i = 0; i < 4; i++) {
			answer = Math.max(answer, dp[land.length-1][i]);
		}

		return answer;
	}

	static int getMax(int[][] dp, int x, int y) {
		int res = 0;
		for (int i = 0; i < 4; i++) {
			if (i == y) continue;
			res = Math.max(res, dp[x][i]);
		}
		return res;
	}
}

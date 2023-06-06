package week14;

import java.io.*;
import java.util.*;

public class boj11660 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] board = new int[n][n];
		int[][] dp = new int[n+1][n+1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (i == 0 && j == 0) dp[i+1][j+1] = board[i][j];
				else if (i == 0) dp[i+1][j+1] = board[i][j] + dp[i+1][j];
				else if (j == 0) dp[i+1][j+1] = board[i][j] + dp[i][j+1];
				else dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j] - dp[i][j] + board[i][j];
			}
		}


		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int res = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
			System.out.println(res);

		}
	}
}

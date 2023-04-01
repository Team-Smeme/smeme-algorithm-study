package week4;

import java.io.*;
import java.util.*;

public class boj2580 {

	static int[][] board = new int[9][9];

	public static void main(String[] args) throws Exception {
		getInput();
		dfs(0, 0);
	}
	
	private static void dfs(int n, int m) {
		if (m == 9) {
			dfs(n+1, 0);
			return;
		}

		if (n == 9) {
			for (int[] line : board) {
				for (int num : line) {
					System.out.print(num + " ");
				}
				System.out.println();
			}

			System.exit(0);
		}


		if (board[n][m] == 0) {
			for (int i = 1; i <= 9; i++) {
				int[] blank = new int[] {n, m};
				if (checkLine(blank, i) && checkLine2(blank, i) && checkSquare(blank, i)) {
					board[n][m] = i;
					dfs(n, m+1);
				}
			}
			board[n][m] = 0;
			return;
		}

		dfs(n, m+1);
	}

	private static boolean checkLine(int[] blank, int targetNum) {
		for (int i = 0; i < 9; i++) {
			if (board[blank[0]][i] == targetNum) {
				return false;
			}
		}

		return true;
	}

	private static boolean checkLine2(int[] blank, int targetNum) {
		for (int i = 0; i < 9; i++) {
			if (board[i][blank[1]] == targetNum) {
				return false;
			}
		}

		return true;
	}

	private static boolean checkSquare(int[] blank, int targetNum) {

		int n = (blank[0] / 3) * 3;
		int m = (blank[1] / 3) * 3;

		for (int i = n; i < n+3; i++) {
			for (int j = m; j < m+3; j++) {
				if (board[i][j] == targetNum) return false;
			}
		}

		return true;
	}

	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}

package week17;

import java.util.*;
import java.io.*;

public class boj1987 {

	static int R, C;
	static String[][] board;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int res = 0;
	static boolean[] alphabet;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new String[R][C];

		for (int i = 0; i < R; i++) {
			String[] arr = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				board[i][j] = arr[j];
			}
		}

		alphabet = new boolean[26];
		alphabet[board[0][0].charAt(0) - 'A'] = true;
		dfs(0, 0, 1);

		System.out.println(res);
	}

	private static void dfs(int x, int y, int n) {

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < R && 0 <= ny && ny < C) {
				if (alphabet[board[nx][ny].charAt(0) - 'A']) {
					res = Math.max(res, n);
					continue;
				}

				alphabet[board[nx][ny].charAt(0) - 'A'] = true;
				dfs(nx, ny, n + 1);
				alphabet[board[nx][ny].charAt(0) - 'A'] = false;
			}
		}

	}
}

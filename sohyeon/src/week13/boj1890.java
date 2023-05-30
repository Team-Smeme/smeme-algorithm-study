package week13;

import java.io.*;
import java.util.*;

public class boj1890 {

	static int N;
	static int[][] board;
	static long[][] table;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		board = new int[N][N];
		table = new long[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0});
		table[0][0] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int next = board[i][j];
				if (next == 0) break;
				if (i + next < N) table[i+next][j] += table[i][j];
				if (j + next < N) table[i][j+next] += table[i][j];
			}
		}

		// while (!queue.isEmpty()) {
		// 	int[] cur = queue.poll();
		// 	int x = cur[0];
		// 	int y = cur[1];
		//
		// 	if (x == N - 1 && y == N - 1) continue;
		//
		// 	int px = x + board[x][y];
		// 	int py = y + board[x][y];
		//
		// 	// 오른쪽
		// 	if (py < N) {
		// 		table[x][py] += table[x][y];
		// 		queue.add(new int[] {x, py});
		// 	}
		//
		// 	// 아래쪽
		// 	if (px < N) {
		// 		table[px][y] += table[x][y];
		// 		queue.add(new int[] {px, y});
		// 	}
		// }

		System.out.println(table[N - 1][N - 1]);
	}
}

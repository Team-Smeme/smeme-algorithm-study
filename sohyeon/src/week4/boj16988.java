package week4;

import java.io.*;
import java.util.*;

public class boj16988 {

	static int N, M;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		input();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0) {
					board[i][j] = 1;
					for (int k = 0; k < N; k++) {
						for (int l = 0; l < M; l++) {
							if (board[k][l] == 0) {
								board[k][l] = 1;
								max = Math.max(max, getRock());
								board[k][l] = 0;
							}
						}
					}
					board[i][j] = 0;
				}
			}
		}

		System.out.println(max);
	}

	private static int getRock() {
		visited = new boolean[N][M];
		int res = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 2 && !visited[i][j]) {
					res += bfs(i, j);
				}
			}
		}

		return res;
	}

	private static int bfs(int i, int j) {
		visited[i][j] = true;
		int res = 0;
		boolean flag = true;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{i, j});

		while (!queue.isEmpty()) {
			int[] now = queue.remove();
			res++;
			for (int k = 0; k < 4; k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (board[nx][ny] == 0) {
						flag = false;
					}
					if (visited[nx][ny] || board[nx][ny] != 2) continue;
					queue.add(new int[]{nx, ny});
					visited[nx][ny] = true;
				}
			}
		}

		return flag ? res : 0;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}

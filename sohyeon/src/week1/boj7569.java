package week1;

import java.io.*;
import java.util.*;

class Tomato {
	int x; // 높이
	int y; // 세로
	int z; // 가로

	public Tomato(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class boj7569 {

	static int M, N, H;
	static int[][][] board;
	static Queue<Tomato> queue;

	public static void main(String[] args) throws Exception {
		getInput();
		System.out.println(bfs());
	}

	private static int bfs() {
		while (!queue.isEmpty()) {

			Tomato t = queue.remove();

			int[] h = {-1, 1};
			for (int i = 0; i < 2; i++) {
				int dh = t.x + h[i];
				if (0 <= dh && dh < H) {
					if (board[dh][t.y][t.z] == 0) {
						board[dh][t.y][t.z] = board[t.x][t.y][t.z] + 1;
						queue.add(new Tomato(dh, t.y, t.z));
					}
				}
			}

			int[] x = {1, -1, 0, 0};
			int[] y = {0, 0, 1, -1};
			for (int i = 0; i < 4; i++) {
				int dx = t.y + x[i];
				int dy = t.z + y[i];
				if (0 <= dx && dx < N && 0 <= dy && dy < M) {
					if (board[t.x][dx][dy] == 0) {
						board[t.x][dx][dy] = board[t.x][t.y][t.z] + 1;
						queue.add(new Tomato(t.x, dx, dy));
					}
				}
			}
		}

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (board[i][j][k] == 0) return -1;
					max = Math.max(max, board[i][j][k]);
				}
			}
		}

		if (max == 1) return 0;
		else return max - 1;
	}

	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		board = new int[H][N][M];
		queue = new LinkedList<>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					board[i][j][k] = Integer.parseInt(st.nextToken());
					if (board[i][j][k] == 1) queue.add(new Tomato(i, j, k));
				}
			}
		}
	}
}

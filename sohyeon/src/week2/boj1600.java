package week2;

import java.io.*;
import java.util.*;

class Position2 {
	int x;
	int y;
	int n;
	int r;

	public Position2(int x, int y, int n, int r) {
		this.x = x;
		this.y = y;
		this.n = n;
		this.r = r;
	}
}

public class boj1600 {

	static int K, W, H;
	static int[][] board;
	static int[] hx = {-2, -1, -2, -1, 1, 2, 2, 1};
	static int[] hy = {-1, -2, 1, 2, -2, -1, 1, 2};
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		getInput();
		bfs();
		System.out.println(min);
	}

	private static void bfs() {
		Queue<Position2> queue = new LinkedList<>();
		queue.add(new Position2(0, 0, 0, 0));

		boolean[][][] visited = new boolean[H][W][K+1];
		visited[0][0][0] = true;

		while (!queue.isEmpty()) {
			Position2 position = queue.remove();

			if (position.x == H - 1 && position.y == W - 1) {
				min = Math.min(min, position.n);
			}

			if (position.r < K) {
				for (int i = 0; i < 8; i++) {
					int nx = hx[i] + position.x;
					int ny = hy[i] + position.y;

					if (0 <= nx && nx < H && 0 <= ny && ny < W) {
						if (!visited[nx][ny][position.r + 1] && board[nx][ny] == 0) {
							visited[nx][ny][position.r + 1] = true;
							queue.add(new Position2(nx, ny, position.n + 1, position.r + 1));
						}
					}
				}
			}

			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + position.x;
				int ny = dy[i] + position.y;

				if (0 <= nx && nx < H && 0 <= ny && ny < W) {
					if (!visited[nx][ny][position.r] && board[nx][ny] == 0) {
						visited[nx][ny][position.r] = true;
						queue.add(new Position2(nx, ny, position.n + 1, position.r));
					}
				}
			}
		}

		if (min == Integer.MAX_VALUE) min = -1;

	}

	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		board = new int[H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}

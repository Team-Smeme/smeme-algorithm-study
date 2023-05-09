package week10;

import java.util.*;
import java.io.*;

class Position2 {
	int x;
	int y;

	Position2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class boj2468 {

	static int N;
	static int[][] board;
	static int MAX_HEIGHT = Integer.MIN_VALUE;
	static int max = Integer.MIN_VALUE;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				MAX_HEIGHT = Math.max(MAX_HEIGHT, board[i][j]);
			}
		}

		for (int h = 0; h <= MAX_HEIGHT; h++) {
			max = Math.max(max, getSafeZone(h));
		}

		System.out.println(max);
	}

	private static int getSafeZone(int h) {
		int count = 0;
		boolean[][] visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] <= h || visited[i][j]) continue;
				bfs(h, visited, i, j);
				count++;
			}
		}

		return count;
	}

	private static void bfs(int h, boolean[][] visited, int x, int y) {
		Queue<Position2> queue = new LinkedList<>();
		queue.offer(new Position2(x, y));
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Position2 cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (visited[nx][ny] || board[nx][ny] <= h) continue;
					queue.offer(new Position2(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
	}
}

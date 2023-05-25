package week12;

import java.io.*;
import java.util.*;

class Marble {
	int rx;
	int ry;
	int bx;
	int by;
	int cnt;

	public Marble(int rx, int ry, int bx, int by, int cnt) {
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.cnt = cnt;
	}
}

public class boj13460 {

	static int N, M;
	static String[][] board;
	static int res = Integer.MAX_VALUE;
	static boolean isEnd = false;
	static Marble red, blue;
	static int hx, hy;
	static boolean[][][][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new String[N][M];
		visited = new boolean[N][M][N][M];

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				board[i][j] = split[j];
				if (board[i][j].equals("O")) {
					hx = i;
					hy = j;
				} else if (board[i][j].equals("R")) {
					red = new Marble(i, j, 0, 0, 0);
				} else if (board[i][j].equals("B")) {
					blue = new Marble(0, 0, i, j, 0);
				}
			}
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Marble> queue = new LinkedList<>();
		queue.add(new Marble(red.rx, red.ry, blue.bx, blue.by, 1));
		visited[red.rx][red.ry][blue.bx][blue.by] = true;

		while (!queue.isEmpty()) {
			Marble marble = queue.poll();

			if (marble.cnt > 10) return -1;

			for (int i = 0; i < 4; i++) {
				int nextRx = marble.rx;
				int nextRy = marble.ry;
				int nextBx = marble.bx;
				int nextBy = marble.by;

				boolean isRedHole = false;
				boolean isBlueHole = false;

				while (!board[nextRx + dx[i]][nextRy + dy[i]].equals("#")) {
					nextRx += dx[i];
					nextRy += dy[i];
					if (nextRx == hx && nextRy == hy) {
						isRedHole = true;
						break;
					}
				}

				while (!board[nextBx + dx[i]][nextBy + dy[i]].equals("#")) {
					nextBx += dx[i];
					nextBy += dy[i];
					if (nextBx == hx && nextBy == hy) {
						isBlueHole = true;
						break;
					}
				}

				if (isBlueHole) continue;
				if (isRedHole) return marble.cnt;

				if (nextRx == nextBx && nextRy == nextBy) {
					if (i == 0) {
						if (marble.rx < marble.bx) nextRx--;
						else nextBx--;
					} else if (i == 1) {
						if (marble.rx > marble.bx) nextRx++;
						else nextBx++;
					} else if (i == 2) {
						if (marble.ry < marble.by) nextRy--;
						else nextBy--;
					} else {
						if (marble.ry > marble.by) nextRy++;
						else nextBy++;
					}
				}

				if (!visited[nextRx][nextRy][nextBx][nextBy]) {
					visited[nextRx][nextRy][nextBx][nextBy] = true;
					queue.add(new Marble(nextRx, nextRy, nextBx, nextBy, marble.cnt + 1));
				}
			}

		}

		return -1;
	}

}

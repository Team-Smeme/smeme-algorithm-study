package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position {
	int x;
	int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class boj2636 {

	static int N, M;
	static int[][] cheese;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int time, count;

	public static void main(String[] args) throws Exception {
		getInput();

		time = 0;
		count = 0;

		while (!isEnd()) {
			bfs();
		}

		System.out.println(time);
		System.out.println(count);
	}

	private static void bfs() {
		boolean[][] visited = new boolean[N][M];

		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(0, 0));
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Position position = queue.remove();

			for (int i = 0; i < 4; i++) {
				int nx = position.x + dx[i];
				int ny = position.y + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (visited[nx][ny]) continue;

					if (cheese[nx][ny] == 1) {
						cheese[nx][ny] = 2;
					} else if (cheese[nx][ny] == 0) {
						queue.add(new Position(nx, ny));
					}

					visited[nx][ny] = true;
				}
			}
		}

		time++;
		count = getCount();
	}

	private static boolean isEnd() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (cheese[i][j] == 1) return false;
			}
		}
		return true;
	}

	private static int getCount() {
		int result = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (cheese[i][j] == 2) {
					result++;
					cheese[i][j] = 0;
				}
			}
		}

		return result;
	}

	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		cheese = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}

package week7;

import java.util.*;

class Position {
	int x;
	int y;
	int n;

	Position(int x, int y, int n) {
		this.x = x;
		this.y = y;
		this.n = n;
	}
}

public class prgrms14 {

	static int N, M;
	static boolean[][] visited;

	public int solution(int[][] maps) {

		N = maps.length;
		M = maps[0].length;
		visited = new boolean[N][M];

		return bfs(0, 0, maps);
	}

	private int bfs(int x, int y, int[][] maps) {
		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(x, y, 1));
		visited[x][y] = true;

		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};

		while (!queue.isEmpty()) {
			Position cur = queue.remove();

			if (cur.x == N-1 && cur.y == M-1) return cur.n;

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (visited[nx][ny] || maps[nx][ny] == 0) continue;
					visited[nx][ny] = true;
					queue.add(new Position(nx, ny, cur.n+1));
				}
			}
		}
		return -1;
	}
}

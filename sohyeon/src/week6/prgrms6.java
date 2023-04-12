package week6;

import java.util.*;

public class prgrms6 {

	static int N, M;
	static boolean[][][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public int[] solution(String[] grid) {

		ArrayList<Integer> answer = new ArrayList<>();

		N = grid.length;
		M = grid[0].length();
		visited = new boolean[N][M][4];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < 4; k++) {
					if (visited[i][j][k]) continue;
					answer.add(light(i, j, k, grid));
				}
			}
		}

		return answer.stream().sorted().mapToInt(i->i).toArray();
	}

	private int light(int i, int j, int d, String[] grid) {
		int cnt = 0;

		while (true) {
			if (visited[i][j][d]) break;

			cnt++;
			visited[i][j][d] = true;

			d = turn(grid[i].charAt(j), d);

			i = i + dx[d];
			if (i < 0) i = N-1;
			else if (i >= N) i = 0;

			j = j + dy[d];
			if (j < 0) j = M-1;
			else if (j >= M) j = 0;
		}

		return cnt;
	}

	static int turn(char c, int d) {
		if (c == 'L') {
			if (d==0) return 2;
			else if (d==1) return 3;
			else if (d==2) return 1;
			else if (d==3) return 0;
		} else if (c == 'R') {
			if (d==0) return 3;
			else if (d==1) return 2;
			else if (d==2) return 0;
			else if (d==3) return 1;
		}
		return d;
	}
}

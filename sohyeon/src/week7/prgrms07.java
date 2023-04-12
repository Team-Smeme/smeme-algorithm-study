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

public class prgrms07 {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static String[][] board;

	public int[] solution(String[][] places) {
		int[] answer = new int[places[0].length];
		for (int i = 0; i < places[0].length; i++) {
			answer[i] = getResult(places[i]);
		}
		return answer;
	}

	private int getResult(String[] place) {
		board = new String[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = String.valueOf(place[i].charAt(j));
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (board[i][j].equals("P")) {
					if (!seat(i, j)) return 0;
				}
			}
		}
		return 1;
	}

	private boolean seat(int x, int y) {
		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(x, y, 0));

		boolean[][] visited = new boolean[5][5];
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Position cur = queue.remove();

			if (cur.n >= 2) continue;

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (0 <= nx && nx < 5 && 0 <= ny && ny < 5) {
					if (visited[nx][ny]) continue;

					visited[nx][ny] = true;

					if (board[nx][ny].equals("P")) return false;
					if (board[nx][ny].equals("X")) continue;
					if (board[nx][ny].equals("O")) {
						queue.add(new Position(nx, ny, cur.n+1));
					}
				}
			}
		}
		return true;
	}
}

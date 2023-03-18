package week3;

import java.io.*;
import java.util.*;

class Puyo {
	int x;
	int y;
	String color;

	public Puyo(int x, int y, String color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
}

public class boj11559 {

	static String[][] board = new String[12][6];
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int res;
	static boolean isEnd;

	public static void main(String[] args) throws Exception {
		getInput();

		res = 0;

		while (true) {
			isEnd = true;

			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (!board[i][j].equals(".")) {
						bfs(new Puyo(i, j, board[i][j]));
					}
				}
			}

			if (isEnd) break;
			else {
				res++;
				down();
			}
		}

		System.out.println(res);
	}

	private static void bfs(Puyo puyo) {
		boolean[][] visited = new boolean[12][6];

		Queue<Puyo> result = new LinkedList<>();
		result.add(puyo);

		Queue<Puyo> queue = new LinkedList<>();
		queue.add(puyo);
		visited[puyo.x][puyo.y] = true;

		while (!queue.isEmpty()) {
			Puyo next = queue.remove();

			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + next.x;
				int ny = dy[i] + next.y;

				if (0 <= nx && nx < 12 && 0 <= ny && ny < 6) {
					if (visited[nx][ny]) continue;

					if (board[nx][ny].equals(puyo.color)) {
						result.add(new Puyo(nx, ny, puyo.color));
						queue.add(new Puyo(nx, ny, puyo.color));
					}

					visited[nx][ny] = true;
				}
			}
		}

		if (result.size() >= 4) {
			while (!result.isEmpty()) {
				Puyo p = result.remove();
				board[p.x][p.y] = ".";
			}
			isEnd = false;
		}
	}

	private static boolean down() {
		boolean flag = false;

		for (int i = 10; i >= 0; i--) {
			for (int j = 0; j < 6; j++) {
				if (!board[i][j].equals(".") && board[i+1][j].equals(".")) {
					falling(i, j);
					flag = true;
				}
			}
		}

		return flag;
	}

	private static void falling(int x, int y) {
		while (x < 11 && board[x+1][y].equals(".")) {
			board[x+1][y] = board[x][y];
			board[x][y] = ".";
			x++;
		}
	}

	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 12; i++) {
			String[] split = br.readLine().split("");
			System.arraycopy(split, 0, board[i], 0, 6);
		}
	}
}

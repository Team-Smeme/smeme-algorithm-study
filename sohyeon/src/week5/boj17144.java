package week5;

import java.util.*;
import java.io.*;

class Dust {
	int x;
	int y;
	int amount;

	Dust (int x, int y, int amount) {
		this.x = x;
		this.y = y;
		this.amount = amount;
	}
}

public class boj17144 {

	static int R, C, T;
	static int[][] board;
	static ArrayList<int[]> clear;
	static Queue<Dust> dusts;

	public static void main(String[] args) throws Exception {
		getInput();

		while (T-- > 0) {
			checkDust();
			blowSand();
			clearSand();
		}

		int count = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == -1) continue;
				count += board[i][j];
			}
		}

		System.out.println(count);

	}

	private static void checkDust() {
		dusts = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == -1 || board[i][j] == 0) continue;
				dusts.add(new Dust(i, j, board[i][j]));
			}
		}
	}

	private static void blowSand() {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		while (!dusts.isEmpty()) {
			Dust dust = dusts.remove();

			if (dust.amount < 5) continue;
			int spread = dust.amount / 5;

			for (int i = 0; i < 4; i++) {
				int nx = dust.x + dx[i];
				int ny = dust.y + dy[i];

				if (0 <= nx && nx < R && 0 <= ny && ny < C) {
					if (board[nx][ny] == -1) continue;
					board[nx][ny] += spread;
					board[dust.x][dust.y] -= spread;
				}
			}
		}
	}

	private static void clearSand() {
		int up = Math.min(clear.get(0)[0], clear.get(1)[0]);
		int down = Math.max(clear.get(0)[0], clear.get(1)[0]);

		// up
		for (int i = up-1; i > 0; i--) board[i][0] = board[i-1][0];
		for (int i = 0; i < C-1; i++) board[0][i] = board[0][i+1];
		for (int i = 0; i < up; i++) board[i][C-1] = board[i+1][C-1];
		for (int i = C-1; i > 1; i--) board[up][i] = board[up][i-1];
		board[up][1] = 0;

		// down
		for (int i = down+1; i < R-1; i++) board[i][0] = board[i+1][0];
		for (int i = 0; i < C-1; i++) board[R-1][i] = board[R-1][i+1];
		for (int i = R-1; i > down; i--) board[i][C-1] = board[i-1][C-1];
		for (int i = C-1; i > 1; i--) board[down][i] = board[down][i-1];
		board[down][1] = 0;
	}

	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		board = new int[R][C];
		clear = new ArrayList<>();

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == -1) clear.add(new int[] {i, j});
			}
		}
	}
}

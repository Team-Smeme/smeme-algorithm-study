package week12;

import java.io.*;
import java.util.*;

public class boj12100 {

	static int N;
	static int[][] board;
	static int res = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		game(0);
		System.out.println(res);

	}

	private static void game(int count) {
		if (count == 5) {
			for (int[] arr : board) {
				for (int block : arr) {
					res = Math.max(res, block);
				}
			}
			return;
		}

		int copy[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			copy[i] = board[i].clone();
		}

		for (int i = 0; i < 4; i++) {
			move(i);
			game(count + 1);
			for (int j = 0; j < N; j++) {
				board[j] = copy[j].clone();
			}
		}
	}

	private static void move(int dir) {
		switch (dir) {
			case 0: // 위
				for (int i = 0; i < N; i++) {
					int index = 0;
					int block = 0;
					for (int j = 0; j < N; j++) {
						if (board[j][i] == 0) continue;
						if (block == board[j][i]) {
							board[index - 1][i] = block * 2;
							block = 0;
							board[j][i] = 0;
						} else {
							block = board[j][i];
							board[j][i] = 0;
							board[index][i] = block;
							index++;
						}
					}
				}
				break;
			case 1: // 아래
					for (int i = 0; i < N; i++) {
						int index = N - 1;
						int block = 0;
						for (int j = N - 1; j >= 0; j--) {
							if (board[j][i] == 0) continue;
							if (block == board[j][i]) {
								board[index + 1][i] = block * 2;
								block = 0;
								board[j][i] = 0;
							} else {
								block = board[j][i];
								board[j][i] = 0;
								board[index][i] = block;
								index--;
							}
						}
					}
					break;
			case 2: // 왼쪽
				for (int i = 0; i < N; i++) {
					int index = 0;
					int block = 0;
					for (int j = 0; j < N; j++) {
						if (board[i][j] == 0) continue;
						if (board[i][j] == block) {
							board[i][index - 1] = block * 2;
							block = 0;
							board[i][j] = 0;
						} else {
							block = board[i][j];
							board[i][j] = 0;
							board[i][index] = block;
							index++;
						}
					}
				}
				break;
			case 3: // 오른쪽
				for (int i = 0; i < N; i++) {
					int index = N - 1;
					int block = 0;
					for (int j = N - 1; j >= 0; j--) {
						if (board[i][j] == 0) continue;
						if (board[i][j] == block) {
							board[i][index + 1] = block * 2;
							block = 0;
							board[i][j] = 0;
						} else {
							block = board[i][j];
							board[i][j] = 0;
							board[i][index] = block;
							index--;
						}
					}
				}
				break;

		}
	}
}

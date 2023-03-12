package week2;

import java.io.*;
import java.util.*;

class Position {
	int x;
	int y;
	int n;

	public Position(int x, int y, int n) {
		this.x = x;
		this.y = y;
		this.n = n;
	}

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class boj14502 {

	static int N, M;
	static int[][] board;
	static int max = 0;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		getInput();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0) {
					board[i][j] = 1;
					for (int k = 0; k < N; k++) {
						for (int l = 0; l < M; l++) {
							if (board[k][l] == 0) {
								board[k][l] = 1;
								for (int q = 0; q < N; q++) {
									for (int p = 0; p < M; p++) {
										if (board[q][p] == 0) {
											board[q][p] = 1;
											bfs();
											board[q][p] = 0;
										}
									}
								}
								board[k][l] = 0;
							}
						}
					}
					board[i][j] = 0;
				}
			}
		}

		System.out.println(max);
	}

	private static void bfs() {
		Queue<Position> virus = getVirus();

		visited = new boolean[N][M];

		while (!virus.isEmpty()) {
			Position position = virus.remove();

			for (int i = 0; i < 4; i++) {
				int nx = position.x + dx[i];
				int ny = position.y + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (!visited[nx][ny] && board[nx][ny] == 0) {
						visited[nx][ny] = true;
						virus.add(new Position(nx, ny));
					}
				}
			}
		}

		int count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0 && !visited[i][j]) {
					count+= 1;
				}
			}
		}

		max = Math.max(max, count);
	}

	private static Queue<Position> getVirus() {
		Queue<Position> virus = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 2) {
					virus.add(new Position(i, j));
				}
			}
		}

		return virus;
	}

	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}

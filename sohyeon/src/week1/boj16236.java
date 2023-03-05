package week1;

import java.util.*;
import java.io.*;

class Shark {
	int x;
	int y;
	int size;
	int eat;

	public Shark(int x, int y, int size, int eat) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.eat = eat;
	}
}

class Fish {
	int x;
	int y;
	int dist;

	public Fish(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}

class Position {
	int x;
	int y;
	int d;

	public Position(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

public class boj16236 {

	static int N;
	static int[][] board;
	static Shark shark;
	static Queue<Fish> fishes;
	static int time;

	public static void main(String[] args) throws Exception {
		getInput();

		fishes = new LinkedList<>();

		while (true) {
			findFishes();

			if (fishes.isEmpty()) {
				System.out.println(time);
				break;
			}

			eatFish();
		}

	}

	private static void eatFish() {
		Fish result = fishes.remove();

		while (!fishes.isEmpty()) {
			Fish fish = fishes.remove();

			if (fish.x < result.x) {
				result.x = fish.x;
				result.y = fish.y;
			} else if (fish.x == result.x && fish.y < result.y) {
				result.y = fish.y;
			}
		}

		shark.x = result.x;
		shark.y = result.y;
		board[result.x][result.y] = 0;
		time += result.dist;

		shark.eat += 1;
		if (shark.eat == shark.size) {
			shark.size += 1;
			shark.eat = 0;
		}
	}

	private static void findFishes() {

		int distance = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 9 || board[i][j] == 0 || board[i][j] >= shark.size) continue;

				int dist = getDistance(i, j);
				if (dist == -1) continue;
				if (dist < distance) {
					distance = dist;
					fishes.clear();
					fishes.add(new Fish(i, j, dist));
				} else if (dist == distance) {
					fishes.add(new Fish(i, j, dist));
				}
			}
		}
	}

	private static int getDistance(int x, int y) {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};

		boolean[][] visited = new boolean[N][N];

		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(x, y, 0));
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Position position = queue.remove();

			if (position.x == shark.x && position.y == shark.y) return position.d;

			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + position.x;
				int ny = dy[i] + position.y;
				if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
					if (board[nx][ny] <= shark.size) {
						visited[nx][ny] = true;
						queue.add(new Position(nx, ny, position.d + 1));
					}
				}
			}
		}

		return -1;
	}

	private static void getInput() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 9) {
					shark = new Shark(i, j, 2, 0);
					board[i][j] = 0;
				}
			}
		}
	}
}

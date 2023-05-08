package week10;

import java.util.*;
import java.io.*;

class Position {
	int x;
	int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class boj2667 {

	static int N;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static ArrayList<Integer> al = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String[] arr = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(arr[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0 || visited[i][j]) continue;
				bfs(i, j);
			}
		}

		System.out.println(al.size());
		Collections.sort(al);
		for (Integer num : al) {
			System.out.println(num);
		}

	}

	private static void bfs(int x, int y) {
		Queue<Position> queue = new LinkedList<>();
		queue.offer(new Position(x, y));
		visited[x][y] = true;

		int count = 1;

		while (!queue.isEmpty()) {
			Position cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (board[nx][ny] == 0 || visited[nx][ny]) continue;
					queue.offer(new Position(nx, ny));
					visited[nx][ny] = true;
					count++;
				}
			}
		}

		al.add(count);
	}
}

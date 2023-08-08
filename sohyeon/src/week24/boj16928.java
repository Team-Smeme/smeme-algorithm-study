package week24;

import java.io.*;
import java.util.*;

public class boj16928 {

	static int N, M;
	static int[] visited = new int[101];
	static int[] board = new int[101];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= 100; i++) {
			board[i] = i;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x] = y;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			board[u] = v;
		}

		System.out.println(bfs());

	}

	private static int bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);

		while (!queue.isEmpty()) {
			int now = queue.poll();

			if (board[now] == 100) {
				return visited[100];
			}

			for (int i = 1; i <= 6; i++) {
				int next = now + i;
				if (next > 100)
					continue;
				next = board[next];
				if (visited[next] == 0) {
					visited[next] = visited[now] + 1;
					queue.add(next);
				}
			}
		}

		return -1;

	}
}

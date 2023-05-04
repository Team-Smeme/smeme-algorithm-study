package week9;

import java.io.*;
import java.util.*;

public class boj1325 {

	static int N, M;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] count;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		count = new int[N+1];

		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(b).add(a);
		}

		for (int i = 1; i <= N; i++) {
			bfs(i);
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i <= N; i++) {
			if (count[i] == max) sb.append(i).append(" ");
		}

		System.out.println(sb);

	}

	private static void bfs(int start) {
		boolean[] visited = new boolean[N+1];
		visited[start] = true;

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);

		while (!queue.isEmpty()) {
			int now = queue.poll();
			count[start]++;

			for (int next : graph.get(now)) {
				if (visited[next]) continue;
				queue.offer(next);
				visited[next] = true;
			}
		}

		max = Math.max(max, count[start]);
	}
}

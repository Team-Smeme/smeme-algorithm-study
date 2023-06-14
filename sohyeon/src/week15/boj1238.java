package week15;

import java.util.*;
import java.io.*;

class City implements Comparable<City> {
	int n;
	int c;

	City(int num, int cost) {
		this.n = num;
		this.c = cost;
	}

	@Override
	public int compareTo(City o) {
		return this.c - o.c;
	}

	@Override
	public String toString() {
		return "City{" +
			"n=" + n +
			", c=" + c +
			'}';
	}
}

public class boj1238 {

	static int N, M, X;
	static ArrayList<ArrayList<int[]>> graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new int[] {b, c});
		}

		int max = Integer.MIN_VALUE;

		for (int i = 1; i <= N; i++) {
			if (i == X) continue;
			max = Math.max(max, dijkstra(i, X) + dijkstra(X, i));
		}

		System.out.println(max);

	}

	private static int dijkstra(int from, int to) {
		PriorityQueue<City> queue = new PriorityQueue<>();

		boolean[] visited = new boolean[N + 1];
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[from] = 0;

		queue.offer(new City(from, 0));

		while (!queue.isEmpty()) {
			City cur = queue.poll();

			if (visited[cur.n]) continue;
			visited[cur.n] = true;

			for (int[] arr : graph.get(cur.n)) {
				if (visited[arr[0]]) continue;
				if (dist[arr[0]] > dist[cur.n] + arr[1]) {
					dist[arr[0]] = dist[cur.n] + arr[1];
					queue.offer(new City(arr[0], dist[arr[0]]));
				}
			}
		}

		return dist[to];
	}
}

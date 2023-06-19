package week16;

import java.util.*;
import java.io.*;

class Node2 {
	int num;
	int weight;

	Node2(int num, int weight) {
		this.num = num;
		this.weight = weight;
	}
}

public class boj1167 {

	static int N;
	static ArrayList<ArrayList<Node2>> graph = new ArrayList<>();
	static boolean[] visited;
	static int max = 0, max_idx = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int p = Integer.parseInt(st.nextToken());

			while (true) {
				int c = Integer.parseInt(st.nextToken());
				if (c == -1) break;
				int w = Integer.parseInt(st.nextToken());
				graph.get(p).add(new Node2(c, w));
				graph.get(c).add(new Node2(p, w));
			}
		}

		visited = new boolean[N+1];
		visited[1] = true;
		dfs(1, 0);

		visited = new boolean[N+1];
		visited[max_idx] = true;
		dfs(max_idx, 0);

		System.out.println(max);
	}

	private static void dfs(int num, int length) {
		if (max < length) {
			max = length;
			max_idx = num;
		}

		for (Node2 next : graph.get(num)) {
			if (visited[next.num]) continue;

			visited[next.num] = true;
			dfs(next.num, length + next.weight);
		}
	}
}

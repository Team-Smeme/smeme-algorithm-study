package week16;

import java.util.*;
import java.io.*;

class Node {
	int num;
	int weight;

	Node(int num, int weight) {
		this.num = num;
		this.weight = weight;
	}
}

public class boj1967 {

	static int N;
	static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
	static boolean[] visited;
	static int max = 0, max_idx = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i <= N; i++) tree.add(new ArrayList<>());

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			tree.get(p).add(new Node(c, w));
			tree.get(c).add(new Node(p, w));
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

		for (Node child : tree.get(num)) {
			if (visited[child.num]) continue;

			visited[child.num] = true;
			dfs(child.num, length + child.weight);
		}
	}
}

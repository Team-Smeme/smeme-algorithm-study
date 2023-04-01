package week5;

import java.util.*;
import java.io.*;

public class boj11725 {

	static int N;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		getInput();
		bfs();
		for (int i = 1; i < parent.length; i++) {
			System.out.println(parent[i] + 1);
		}
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		visited[0] = true;

		while (!queue.isEmpty()) {
			Integer node = queue.remove();

			for (Integer child : graph.get(node)) {
				if (visited[child]) continue;

				parent[child] = node;
				visited[child] = true;
				queue.add(child);
			}
		}
	}

	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}
		visited = new boolean[N];
		parent = new int[N];

		while (N-- > 1) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a-1).add(b-1);
			graph.get(b-1).add(a-1);
		}
	}
}

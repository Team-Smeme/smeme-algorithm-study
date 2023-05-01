package week9;

import java.util.*;
import java.io.*;

public class boj11403 {

	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[][] route = new int[n][n];

		for(int i = 0; i < n; i++) graph.add(new ArrayList<>());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				if (Integer.parseInt(st.nextToken()) == 0) continue;
				graph.get(i).add(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (hasRoute(i, j)) route[i][j] = 1;
			}
		}

		for (int[] r : route) {
			for (int i = 0; i < n; i++) {
				System.out.print(r[i] + " ");
			}
			System.out.println();
		}
	}

	private static boolean hasRoute(int from, int to) {
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(from);

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int next : graph.get(now)) {
				if (visited[next]) continue;
				if (next == to) return true;
				queue.offer(next);
				visited[next] = true;
			}
		}

		return false;
	}
}

package week9;

import java.util.*;
import java.io.*;

public class boj10451 {

	static int N, count;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			N = Integer.parseInt(br.readLine());
			graph = new ArrayList<>();
			for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				graph.get(i).add(Integer.parseInt(st.nextToken()));
			}
			visited = new boolean[N+1];
			count = 0;
			for (int i = 1; i <= N; i++) {
				if (bfs(i)) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

	private static boolean bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);

		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int next : graph.get(now)) {
				if (visited[next]) continue;
				queue.offer(next);
				visited[next] = true;
				if (next == start) return true;
			}
		}

		return false;
	}
}

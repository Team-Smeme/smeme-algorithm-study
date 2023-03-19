package week3;

import java.io.*;
import java.util.*;

public class boj6118 {

	static int N, M;
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws Exception {
		getInput();

		int distance = -1;
		int count = 0;
		int number = 0;

		boolean[] visited = new boolean[N+1];
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{1, 0});
		visited[1] = true;
		
		while (!queue.isEmpty()) {
			int[] arr = queue.remove(); // 목적지, 거리

			if (arr[1] > distance) {
				distance = arr[1];
				count = 1;
				number = arr[0];
			} else if (arr[1] == distance) {
				count += 1;
				number = Math.min(number, arr[0]);
			}

			for (int next : graph.get(arr[0])) {
				if (visited[next]) continue;
				visited[next] = true;
				queue.add(new int[]{next, arr[1] + 1});
			}
		}

		System.out.println(number + " " + distance + " " + count);

	}

	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
	}
}

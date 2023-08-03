package week21;

import java.io.*;
import java.util.*;

public class boj2606 {

	static int N, M;
	static ArrayList<ArrayList<Integer>> al = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		for (int i = 0; i <= N; i++) {
			al.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			al.get(a).add(b);
			al.get(b).add(a);
		}

		boolean[] visited = new boolean[N + 1];
		visited[1] = true;

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);

		while (!queue.isEmpty()) {
			int num = queue.poll();

			for (int n : al.get(num)) {
				if (visited[n]) continue;

				queue.add(n);
				visited[n] = true;
			}
		}

		int res = 0;

		for (int i = 2; i <= N; i++) {
			if (visited[i]) res++;
		}

		System.out.println(res);
	}
}

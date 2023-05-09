package week10;

import java.io.*;
import java.util.*;

public class boj2644 {

	static int N;
	static List<Integer>[] relation;
	static boolean[] visited;
	static int res = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		relation = new ArrayList[N+1];
		visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			relation[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			relation[p].add(c);
			relation[c].add(p);
		}

		dfs(a, b, 0);
		System.out.println(res);
	}

	private static void dfs(int start, int end, int cnt) {
		if (start == end) {
			res = cnt;
		}

		visited[start] = true;

		for (int next : relation[start]) {
			if (!visited[next]) dfs(next, end, cnt+1);
		}
	}
}

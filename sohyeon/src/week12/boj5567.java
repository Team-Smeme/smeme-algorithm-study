package week12;

import java.io.*;
import java.util.*;

class Data {
	int num;
	int distance;

	Data(int num, int distance) {
		this.num = num;
		this.distance = distance;
	}
}

public class boj5567 {

	static int N, M;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] joined;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		joined = new boolean[N];

		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a - 1).add(b - 1);
			graph.get(b - 1).add(a - 1);
		}

		getFriend(0);

		int res = 0;
		for (int i = 1; i < N; i++) {
			if (joined[i]) res++;
		}

		System.out.println(res);

	}

	private static void getFriend(int num) {
		Queue<Data> queue = new LinkedList<>();
		queue.add(new Data(num, 0));

		while(!queue.isEmpty()) {
			Data cur = queue.poll();
			for (int f : graph.get(cur.num)) {
				if (joined[f]) continue;
				if (cur.distance + 1 <= 2) {
					joined[f] = true;
					queue.add(new Data(f, cur.distance + 1));
				}
			}
		}
	}
}

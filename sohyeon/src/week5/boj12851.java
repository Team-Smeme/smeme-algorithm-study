package week5;

import java.util.*;
import java.io.*;

public class boj12851 {

	static int N, K;
	static int min = Integer.MAX_VALUE;
	static int count = 0;
	static int[] visited= new int[100001];

	public static void main(String[] args) throws Exception {
		getInput();

		if(N >= K) {
			System.out.println(N-K);
			System.out.println(1);
			return;
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		visited[N] = 1;

		while (!queue.isEmpty()) {
			Integer cur = queue.remove();

			if (visited[cur] > min) continue;

			for (int i = 0; i < 3; i++) {
				int next;

				if (i == 0) next = cur + 1;
				else if (i == 1) next = cur -1;
				else next = cur * 2;

				if (next < 0 || next > 100000) continue;

				if (next == K) {
					min = visited[cur];
					count++;
				}

				if (visited[next] == 0 || visited[next] == visited[cur] + 1) {
					queue.add(next);
					visited[next] = visited[cur] + 1;
				}
			}
		}

		System.out.println(min);
		System.out.println(count);

	}

	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	}
}

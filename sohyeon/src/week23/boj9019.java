package week23;


import java.io.*;
import java.util.*;

public class boj9019 {

	static int T;
	static ArrayList<String> cmd;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			cmd = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(bfs(a, b));
		}

	}

	private static String bfs(int a, int b) {
		String[] cmd = new String[10000];
		Arrays.fill(cmd, "");

		boolean[] visited = new boolean[10000];
		visited[a] = true;

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(a);

		while (!queue.isEmpty() && !visited[b]) {
			int now = queue.poll();

			int next = D(now);
			if (!visited[next]) {
				queue.add(next);
				visited[next] = true;
				cmd[next] = cmd[now] + "D";
			}

			next = S(now);
			if (!visited[next]) {
				queue.add(next);
				visited[next] = true;
				cmd[next] = cmd[now] + "S";
			}

			next = L(now);
			if (!visited[next]) {
				queue.add(next);
				visited[next] = true;
				cmd[next] = cmd[now] + "L";
			}

			next = R(now);
			if (!visited[next]) {
				queue.add(next);
				visited[next] = true;
				cmd[next] = cmd[now] + "R";
			}
		}

		return cmd[b];
	}

	private static int D(int n) {
		return (n * 2) % 10000;
	}

	private static int S(int n) {
		return n != 0 ? n - 1 : 9999;
	}

	private static int L(int n) {
		return (n % 1000) * 10 + (n / 1000);
	}

	private static int R(int n) {
		return (n % 10) * 1000 + (n / 10);
	}

}

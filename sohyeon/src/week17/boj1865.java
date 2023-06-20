package week17;

import java.io.*;
import java.util.*;

class World {
	int num;
	int cost;

	World(int num, int cost) {
		this.num = num;
		this.cost = cost;
	}
}

public class boj1865 {

	static ArrayList<ArrayList<World>> graph;
	static int[] dist;
	static boolean res;
	static int n, m, w;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		while (TC-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			graph = new ArrayList<>();
			for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				graph.get(s).add(new World(e, t));
				graph.get(e).add(new World(s, t));
			}

			for (int i = 0; i < w; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				graph.get(s).add(new World(e, (-1) * t));
			}

			res = false;
			dist = new int[n + 1];

			System.out.println(bellmanFord() ? "YES" : "NO");
		}
	}

	private static boolean bellmanFord() {
		Arrays.fill(dist, Integer.MAX_VALUE - 10000);
		dist[1] = 0;
		boolean update = false;

		for (int d = 1; d < n; d++) {
			update = false;
			for (int i = 1; i <= n; i++) {
				for (World world : graph.get(i)) {
					if (dist[world.num] > dist[i] + world.cost) {
						dist[world.num] = dist[i] + world.cost;
						update = true;
					}
				}
			}
			if (!update) {
				break;
			}
		}

		// System.out.println(Arrays.toString(dist));

		if (update) {
			for (int i = 1; i <= n; i++) {
				for (World world : graph.get(i)) {
					if (dist[world.num] > dist[i] + world.cost) {
						return true;
					}
				}
			}
		}

		return false;
	}
}

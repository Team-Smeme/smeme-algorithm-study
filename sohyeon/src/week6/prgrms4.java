package week6;

import java.util.*;

public class prgrms4 {

	static int res = Integer.MAX_VALUE;
	static int[] parent;

	public int solution(int n, int[][] wires) {
		for (int i = 0; i < n-1; i++) {
			parent = new int[n+1];
			for(int k = 0; k <= n; k++) parent[k] = k;
			for (int j = 0; j < n-1; j++) {
				if (i == j) continue;
				union(wires[j][0], wires[j][1]);
			}
			update();
		}

		return res;
	}

	private void update() {
		int[] team = new int[parent.length];
		for (int i = 1; i < parent.length; i++) {
			int p = getParent(i);
			team[p]++;
		}

		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 1; i < team.length; i++) {
			if (team[i] > 0) al.add(team[i]);
		}

		System.out.println(al.size());

		int diff = Math.abs(al.get(0) - al.get(1));
		res = Math.min(res, diff);
	}

	private int getParent(int num) {
		int x = parent[num];
		if (x == num) return x;
		else return parent[num] = getParent(x);
	}

	private void union(int a, int b) {
		int rootA = getParent(a);
		int rootB = getParent(b);
		if (rootA == rootB) return;
		else if (rootA < rootB) parent[rootB] = rootA;
		else parent[rootA] = rootB;
	}
}

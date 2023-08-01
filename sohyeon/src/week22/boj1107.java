package week22;

import java.util.*;
import java.io.*;

public class boj1107 {

	static String N;
	static ArrayList<Integer> al = new ArrayList<>();
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = br.readLine();

		int m = Integer.parseInt(br.readLine());
		if (m > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				al.add(Integer.parseInt(st.nextToken()));
			}
		}

		if (N.equals("100")) {
			System.out.println(0);
			return;
		}

		int cnt = Math.abs(Integer.parseInt(N) - 100);
		min = Math.min(min, cnt);

		dfs(0, "");
		System.out.println(min);
	}

	private static void dfs(int idx, String click) {
		for (int i = 0; i <= 9; i++) {
			if (!al.contains(i)) {
				String str = click + String.valueOf(i);
				int cnt = Math.abs(Integer.parseInt(N) - Integer.parseInt(str)) + str.length();
				min = Math.min(min, cnt);
				if (idx < 6) dfs(idx + 1, str);
			}
		}
	}
}

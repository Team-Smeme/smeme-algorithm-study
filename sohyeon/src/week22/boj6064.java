package week22;


import java.io.*;
import java.util.*;

public class boj6064 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			sb.append(solve(N, M, x, y)).append("\n");
		}

		System.out.println(sb);

	}

	private static int solve(int N, int M, int x, int y) {
		for (int i = x; i < (N * M); i += N) {
			if (i % M == y) {
				return i + 1;
			}
		}

		return -1;
	}

}

package week21;

import java.util.*;
import java.io.*;

public class boj18111 {

	static int N, M, B;
	static int[][] ground;
	static int t, h;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		B = Integer.parseInt(st.nextToken()); // 블록 개수

		ground = new int[N][M];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, ground[i][j]);
			}
		}

		t = Integer.MAX_VALUE;
		h = 0;

		work(max);

		System.out.println(t + " " + h);
	}

	private static void work(int max) {
		for (int i = 0; i <= max; i++) {
			int[] res = check(i);
			int time = res[0];
			int height = res[1];

			if (time < t) {
				t = time;
				h = height;
			} else if (time == t) {
				h = Math.max(h, height);
			}
		}
	}

	private static int[] check(int height) {
		int block = B;
		int time = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int value = ground[i][j];

				// 블록 넣기
				if (value > height) {
					time += (value - height) * 2;
					block += (value - height);
				}

				// 블록 쌓기
				else if (value < height) {
					time += (height - value);
					block -= (height - value);
				}
			}
		}

		if (block < 0) {
			return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
		} else {
			return new int[] {time, height};
		}
	}
}

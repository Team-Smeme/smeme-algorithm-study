package week2;

import java.io.*;

public class boj1058 {

	static int N;
	static long[][] friends;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		getInput();
		System.out.println(getResult());
	}

	private static int getResult() {
		fluid();

		for (int i = 0; i < N; i++) {
			int res = 0;
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				if (friends[i][j] <= 2) res++;
			}
			max = Math.max(max, res);
		}

		return max;
	}

	private static void fluid() {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (k == i || i == j || j == k) continue;
					if (friends[i][j] > friends[i][k] + friends[k][j]) {
						friends[i][j] = friends[i][k] + friends[k][j];
					}
				}
			}
		}
	}

	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		friends = new long[N][N];

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				String str = split[j];
				if (str.equals("Y")) friends[i][j] = 1;
				else friends[i][j] = Integer.MAX_VALUE;
			}
		}
	}
}

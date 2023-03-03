package week1;

import java.io.*;
import java.util.*;

public class boj14888 {

	static int N;
	static int[] numbers, operator;
	static boolean[] visited;
	static int max, min;

	public static void main(String[] args) throws Exception {
		getInput();

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		dfs(numbers[0], 1);

		System.out.println(max);
		System.out.println(min);
	}

	private static void dfs(int result, int index) {
		for (int i = 0; i < 4; i++) {

			if (index >= numbers.length) {
				max = Math.max(max, result);
				min = Math.min(min, result);
				continue;
			}

			if (operator[i] <= 0) continue;

			operator[i]--;

			switch (i) {
				case 0:
					dfs(result + numbers[index], index + 1);
					break;
				case 1:
					dfs(result - numbers[index], index + 1);
					break;
				case 2:
					dfs(result * numbers[index], index + 1);
					break;
				case 3:
					dfs(result / numbers[index], index + 1);
					break;
			}

			operator[i]++;
		}
	}

	private static void getInput() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());

		operator = new int[4]; // + - * /
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) operator[i] = Integer.parseInt(st.nextToken());
	}
}

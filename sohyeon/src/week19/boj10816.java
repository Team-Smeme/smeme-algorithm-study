package week19;

import java.util.*;
import java.io.*;

public class boj10816 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append((rightPosition(arr, num) - leftPosition(arr, num)) + " ");
		}
		System.out.println(sb);
	}

	private static int leftPosition(int[] arr, int num) {
		int start = 0;
		int end = arr.length;

		while (start < end) {
			int mid = (start + end) / 2;

			if (num <= arr[mid]) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return start;
	}

	private static int rightPosition(int[] arr, int num) {
		int start = 0;
		int end = arr.length;

		while (start < end) {
			int mid = (start + end) / 2;

			if (num < arr[mid]) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return start;
	}
}

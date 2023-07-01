package week18;

import java.util.*;
import java.io.*;

public class boj10809 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int[] arr = new int[26];
		Arrays.fill(arr, -1);

		for (int i = 0; i < str.length(); i++) {
			int idx = str.charAt(i) - 'a';
			if (arr[idx] != -1) continue;
			arr[idx] = i;
		}

		StringBuilder sb = new StringBuilder();

		for (int num : arr) {
			sb.append(num).append(" ");
		}

		System.out.println(sb);

	}
}

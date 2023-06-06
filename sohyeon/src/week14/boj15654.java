package week14;

import java.io.*;
import java.util.*;

public class boj15654 {

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		comb(new ArrayList<>());

	}

	private static void comb(ArrayList<Integer> al) {
		if (al.size() == M) {
			for (int num : al) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (al.contains(arr[i])) continue;
			int num = arr[i];
			al.add(num);
			comb(al);
			al.remove(al.size() - 1);
		}
	}
}

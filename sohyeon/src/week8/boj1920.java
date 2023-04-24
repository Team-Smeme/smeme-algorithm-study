package week8;

import java.io.*;
import java.util.*;

// 수 찾기 (이진 트리 탐색)
public class boj1920 {

	static ArrayList<Integer> al = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			al.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(al);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			System.out.println(bs(num));
		}
	}

	private static int bs(int num) {
		int left = 0;
		int right = al.size() - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (al.get(mid) == num) return 1;

			if (num > al.get(mid)) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return 0;
	}
}

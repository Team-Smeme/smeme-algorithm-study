package week8;

import java.util.*;

// 수 정렬하기2 (정렬)
public class boj2751 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			al.add(sc.nextInt());
		}

		Collections.sort(al);

		for (int num : al) {
			sb.append(num).append("\n");
		}

		System.out.println(sb);
	}
}

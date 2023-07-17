package week21;

import java.io.*;
import java.util.*;

public class boj18110 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			al.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(al);

		int p = (int)Math.round(N * 0.15);
		int sum = 0;
		int cnt = N - 2 * p;
		for (int i = p; i < N - p; i++) {
			sum += al.get(i);
		}

		System.out.println(Math.round((double)sum / (double)cnt));
	}
}

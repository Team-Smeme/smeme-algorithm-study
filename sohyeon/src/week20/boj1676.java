package week20;

import java.io.*;
import java.util.*;

public class boj1676 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			int num = i;
			while (num % 5 == 0) {
				cnt++;
				num /= 5;
			}
		}

		System.out.println(cnt);

	}
}

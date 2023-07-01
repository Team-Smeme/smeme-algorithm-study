package week18;

import java.util.*;
import java.io.*;

public class boj8958 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());

		while (c-- > 0) {
			String[] arr = br.readLine().split("");
			int temp = arr[0].equals("O") ? 1 : 0;
			int score = temp;
			for (int i = 1; i < arr.length; i++) {
				if (arr[i].equals("O")) {
					temp++;
				} else {
					temp = 0;
				}
				score += temp;
			}
			System.out.println(score);
		}
	}
}

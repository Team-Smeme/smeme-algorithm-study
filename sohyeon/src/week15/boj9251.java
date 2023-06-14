package week15;

import java.io.*;
import java.util.*;

public class boj9251 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str1 = br.readLine().split("");
		String[] str2 = br.readLine().split("");

		int[][] board = new int[str1.length + 1][str2.length + 1];

		for (int j = 1; j <= str2.length; j++) {
			for (int i = 1; i <= str1.length; i++) {
				if (str1[i - 1].equals(str2[j - 1])) board[i][j] = board[i - 1][j - 1] + 1;
				else board[i][j] = Math.max(board[i][j - 1], board[i - 1][j]);
			}
		}

		// for (int[] arr : board) {
		// 	System.out.println(Arrays.toString(arr));
		// }

		System.out.println(board[str1.length][str2.length]);
	}
}

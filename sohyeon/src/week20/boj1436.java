package week20;

import java.io.*;
import java.util.*;

public class boj1436 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int num = 666;
		int count = 1;

		while (count != N) {
			num++;

			if (String.valueOf(num).contains("666")) {
				count++;
			}
		}

		System.out.println(num);
	}
}

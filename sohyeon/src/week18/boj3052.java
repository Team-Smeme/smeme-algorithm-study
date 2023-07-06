package week18;

import java.io.*;
import java.util.*;

public class boj3052 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Integer> al = new ArrayList<>();

		int c = 10;
		while (c-- > 0) {
			int num = Integer.parseInt(br.readLine());
			int remain = num % 42;
			if (!al.contains(remain)) al.add(remain);
		}

		System.out.println(al.size());
	}
}

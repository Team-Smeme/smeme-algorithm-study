package week18;

import java.io.*;
import java.util.*;

public class boj11720 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split("");
		int res = 0;
		for (String str : arr) {
			res += Integer.parseInt(str);
		}
		System.out.println(res);
	}
}

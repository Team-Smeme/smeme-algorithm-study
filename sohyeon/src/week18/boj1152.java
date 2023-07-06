package week18;

import java.io.*;
import java.util.*;

public class boj1152 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int res = 0;
		for (String str : arr) {
			if (str.length() < 1) continue;
			res++;
		}
		System.out.println(res);
	}
}

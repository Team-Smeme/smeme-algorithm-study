package week8;

import java.util.*;
import java.io.*;

// 괄호 (스택)
public class boj9012 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0 ; i < n; i++) {
			System.out.println(isValidParen(br.readLine().split("")));
		}
	}

	private static String isValidParen(String[] arr) {
		if (arr[0].equals(")") || arr.length < 2) return "NO";

		Stack<String> stack = new Stack<>();
		stack.push(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			if (arr[i].equals("(")) stack.push(arr[i]);
			else {
				if (stack.isEmpty()) return "NO";
				stack.pop();
			}
		}

		if (!stack.isEmpty()) return "NO";

		return "YES";
	}
}

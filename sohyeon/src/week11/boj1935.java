package week11;

import java.util.*;
import java.io.*;

public class boj1935 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		double[] arr = new double[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}

		Stack<Double> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
				stack.push(arr[str.charAt(i) - 'A']);
			} else {
				if (!stack.isEmpty()) {
					double right = stack.pop();
					double left = stack.pop();
					double temp = 0;
					switch (str.charAt(i)) {
						case '+':
							temp = left + right;
							break;
						case '-':
							temp = left - right;
							break;
						case '*':
							temp = left * right;
							break;
						case '/':
							temp = left / right;
							break;
					}
					stack.push(temp);
				}
			}
		}

		System.out.printf("%.2f%n", stack.pop());
	}
}

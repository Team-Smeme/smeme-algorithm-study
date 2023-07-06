package week18;

import java.io.*;

public class boj2920 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");

		String res = Integer.parseInt(arr[0]) < Integer.parseInt(arr[1]) ? "ascending" : "descending";

		for (int i = 1; i < arr.length; i++) {
			if (Math.abs(Integer.parseInt(arr[i - 1]) - Integer.parseInt(arr[i])) != 1) {
				res = "mixed";
				break;
			}
			if (res.equals("ascending") && Integer.parseInt(arr[i - 1]) > Integer.parseInt(arr[i])) {
				res = "mixed";
				break;
			}
			if (res.equals("descending") && Integer.parseInt(arr[i - 1]) < Integer.parseInt(arr[i])) {
				res = "mixed";
				break;
			}
		}

		System.out.println(res);
	}
}

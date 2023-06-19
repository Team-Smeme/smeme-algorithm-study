package week16;

import java.io.*;
import java.util.*;

public class boj11444 {

	static long MOD = 1000000007;
	static long[][] origin = {{1, 1}, {1, 0}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long[][] A = {{1, 1}, {1, 0}};
		System.out.println(pow(A, n - 1)[0][0]);
	}

	private static long[][] pow(long[][] A, long num) {
		if (num == 1 || num == 0) return A;

		long[][] ret = pow(A, num / 2);
		ret = multiply(ret, ret);

		if (num % 2 == 1L) {
			ret = multiply(ret, origin);
		}

		return ret;
	}

	private static long[][] multiply(long[][] x, long[][] y) {
		long[][] res = new long[2][2];

		res[0][0] = (x[0][0] * y[0][0] + x[0][1] * y[1][0]) % MOD;
		res[0][1] = (x[0][0] * y[0][1] + x[0][1] * y[1][1]) % MOD;
		res[1][0] = (x[1][0] * y[0][0] + x[1][1] * y[1][0]) % MOD;
		res[1][1] = (x[1][0] * y[0][1] + x[1][1] * y[1][1]) % MOD;

		return res;
	}
}

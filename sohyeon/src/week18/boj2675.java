package week18;

import java.util.*;
import java.io.*;

public class boj2675 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int c = Integer.parseInt(br.readLine());
		while (c-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String[] arr = st.nextToken().split("");
			StringBuilder sb = new StringBuilder();
			for (String str : arr) {
				for (int i = 0; i < num; i++) {
					sb.append(str);
				}
			}
			System.out.println(sb);
		}
	}
}

package week13;

import java.util.*;
import java.io.*;

import jdk.jfr.Frequency;

public class boj1062 {

	static int N, K;
	static boolean[] alphabets;
	static String[] words;
	static int res = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		words = new String[N];
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			word = word.replace("anta", "");
			word = word.replace("tica", "");
			words[i] = word;
		}

		if (K < 5) {
			System.out.println(0);
			return;
		}

		if (K >= 26) {
			System.out.println(N);
			return;
		}

		alphabets = new boolean[26];
		alphabets['a' - 'a'] = true;
		alphabets['n' - 'a'] = true;
		alphabets['t'  - 'a'] = true;
		alphabets['i' - 'a'] = true;
		alphabets['c' - 'a'] = true;

		teach(0, 0);
		System.out.println(res);
	}

	private static void teach(int len, int start) {
		if (len + 5 >= K) {
			int temp = 0;
			for (String word: words) {
				boolean isRead = true;
				for (int i = 0; i < word.length(); i++) {
					if (!alphabets[word.charAt(i) - 'a']) {
						isRead = false;
						break;
					}
				}
				if (isRead) {
					temp++;
				}
			}
			res = Math.max(res, temp);
			return;
		}

		for (int i = start; i < 26; i++) {
			if (alphabets[i]) continue;
			alphabets[i] = true;
			teach(len + 1, i);
			alphabets[i] = false;
		}
	}


}

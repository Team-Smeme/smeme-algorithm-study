package week11;

import java.util.*;
import java.io.*;

class Trie {
	boolean end;
	boolean pass;
	Trie[] child;

	Trie() {
		this.end = false;
		this.pass = false;
		child = new Trie[10];
	}

	public boolean insert(String str, int i) {
		if (end) return false;

		if (i == str.length()) {
			end = true;
			return !pass;
		}

		int next = str.charAt(i) - '0';
		if (child[next] == null) {
			child[next] = new Trie();
			pass = true;
		}

		return child[next].insert(str, i + 1);
	}
}

public class boj5052 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			Trie trie = new Trie();
			int n = Integer.parseInt(br.readLine());
			boolean flag = false;
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				boolean result = trie.insert(str, 0);
				if (!result) flag = true;
			}
			if (flag)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}
}

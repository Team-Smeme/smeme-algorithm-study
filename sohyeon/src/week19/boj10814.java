package week19;

import java.util.*;
import java.io.*;

public class boj10814 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashMap<Integer, ArrayList<String>> map = new HashMap<>();
		ArrayList<Integer> keys = new ArrayList<>();

		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			if (map.containsKey(age)) {
				map.get(age).add(name);
			} else {
				keys.add(age);
				ArrayList<String> al = new ArrayList<>();
				al.add(name);
				map.put(age, al);
			}
		}

		Collections.sort(keys);

		for (int key : keys) {
			ArrayList<String> names = map.get(key);
			for (String name : names) {
				System.out.println(key + " " + name);
			}
		}

	}
}

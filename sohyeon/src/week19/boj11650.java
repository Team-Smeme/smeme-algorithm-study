package week19;

import java.io.*;
import java.util.*;

public class boj11650 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		ArrayList<Integer> keys = new ArrayList<>();
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (!map.containsKey(x)) {
				ArrayList<Integer> al = new ArrayList<>();
				al.add(y);
				map.put(x, al);
				keys.add(x);
			} else {
				map.get(x).add(y);
			}
		}

		Collections.sort(keys);

		for (int key : keys) {
			ArrayList<Integer> al = map.get(key);
			Collections.sort(al);
			for (int y : al) {
				System.out.println(key + " " + y);
			}
		}
	}
}

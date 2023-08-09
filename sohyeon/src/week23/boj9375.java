package week23;


import java.io.*;
import java.util.*;

public class boj9375 {

	static int T;
	static ArrayList<String> cmd;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, ArrayList<String>> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String type = st.nextToken();
				if (map.containsKey(type)) {
					map.get(type).add(type);
				} else {
					ArrayList<String> al = new ArrayList<>();
					al.add(name);
					map.put(type, al);
				}
			}
			int c = 1;
			for (String type : map.keySet()) {
				c *= (map.get(type).size() + 1);
			}
			System.out.println(c - 1);
		}

	}


}
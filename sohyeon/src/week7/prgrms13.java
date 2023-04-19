package week7;

import java.util.*;

public class prgrms13 {

	static int res = 0;

	public int solution(String s) {

		if (s.length() == 1) return 0;

		for (int i = 0; i < s.length(); i++) {
			s = rotate(s);
		}

		return res;
	}

	private String rotate(String s) {
		String[] arr = s.split("");

		ArrayList<String> al = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) continue;
			al.add(arr[i]);
		}
		al.add(arr[0]);

		if(isRight(al)) res++;

		StringBuilder sb = new StringBuilder();
		for (String str : al) {
			sb.append(str);
		}
		return sb.toString();
	}

	private boolean isRight(ArrayList<String> al) {
		Queue<String> queue = new LinkedList<>();
		for (String str : al) queue.add(str);

		ArrayList<String> store = new ArrayList<>();

		while(!queue.isEmpty()) {
			String q = queue.remove();

			if (q.equals("(") || q.equals("{") || q.equals("[")) store.add(q);
			else {
				if (store.size() == 0) return false;
				if (q.equals(")")) {
					if (!store.get(store.size()-1).equals("(")) return false;
				} else if (q.equals("}")) {
					if (!store.get(store.size()-1).equals("{")) return false;
				} else if (q.equals("]")) {
					if (!store.get(store.size()-1).equals("[")) return false;
				}
				store.remove(store.size()-1);
			}
		}

		return store.size() == 0 ? true : false;
	}
}

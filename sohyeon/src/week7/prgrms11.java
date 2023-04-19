package week7;

import java.util.*;

public class prgrms11 {

	static HashMap<String, Integer> map = new HashMap<>();
	static int max;
	static int[] stars;
	static ArrayList<Integer> courses = new ArrayList<>();

	public String[] solution(String[] orders, int[] course) {
		max = course[course.length - 1];
		stars = new int[max+1];
		for (int c : course) courses.add(c);

		for (String order : orders) {
			String[] arr = sortStr(order).split("");
			for (String str : arr) {
				comb(str, 1, arr);
			}
		}

		ArrayList<String> al = new ArrayList<>();

		for (String key : map.keySet()) {
			if (map.get(key) > 1 && stars[key.length()] == map.get(key)) {
				al.add(key);
			}
		}

		Collections.sort(al);

		String[] answer = new String[al.size()];
		for (int i = 0; i < al.size(); i++) {
			answer[i] = al.get(i);
		}

		return answer;
	}

	private void comb(String str, int depth, String[] arr) {

		if (depth > max) return;

		if (courses.contains(depth)) {
			if (!map.containsKey(str)) map.put(str, 0);
			map.put(str, map.get(str)+1);
			stars[depth] = Math.max(stars[depth], map.get(str));
		}

		String last = String.valueOf(str.charAt(str.length()-1));
		int index = Arrays.asList(arr).indexOf(last);

		for (int i = index+1; i < arr.length; i++) {
			if (i >= arr.length) break;
			comb(str+arr[i], depth+1, arr);
		}
	}

	private String sortStr(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
}

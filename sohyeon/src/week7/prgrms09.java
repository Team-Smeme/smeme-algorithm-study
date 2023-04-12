package week7;

import java.util.*;

class prgrms09 {
	static HashMap<String, List<Integer>> map = new HashMap<>();

	public int[] solution(String[] info, String[] query) {

		for (int i = 0; i < info.length; i++) comb("", 0, info[i].split(" "));
		for (String key : map.keySet()) Collections.sort(map.get(key));

		int[] answer = new int[query.length];

		for (int i = 0; i < query.length; i++) {
			String str = query[i].replaceAll(" and ", "");
			String[] temp = str.split(" ");
			answer[i] = bs(temp[0], Integer.parseInt(temp[1]));
		}

		return answer;
	}

	private static int bs(String str, int score) {
		if (!map.containsKey(str)) return 0;

		List<Integer> al = map.get(str);
		int start = 0;
		int end = al.size() - 1;

		while (start <= end) {
			int mid = (start+end)/2;

			if (score > al.get(mid)) start = mid+1;
			else end = mid-1;
		}

		return al.size() - start;
	}

	private static void comb(String str, int depth, String[] arr) {
		if (depth == 4) {
			int score = Integer.parseInt(arr[4]);
			if (!map.containsKey(str)) {
				List<Integer> al = new ArrayList<>();
				map.put(str, al);
			}
			map.get(str).add(score);
			return;
		}
		comb(str+"-", depth+1, arr); // 전체 필터
		comb(str+arr[depth], depth+1, arr); // 특정 필터
	}

}
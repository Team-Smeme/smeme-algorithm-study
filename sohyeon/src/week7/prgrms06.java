package week7;

import java.util.*;

public class prgrms06 {
	public int[] solution(int[] lottos, int[] win_nums) {

		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < win_nums.length; i++) {
			al.add(win_nums[i]);
		}

		int cnt = 0;
		int zero = 0;

		for (int i = 0; i < lottos.length; i++) {
			if (al.contains(lottos[i])) cnt++;
			else if (lottos[i] == 0) zero++;
		}

		System.out.println(cnt);

		int[] answer = {getResult(cnt+zero), getResult(cnt)};
		return answer;
	}

	private int getResult(int cnt) {
		if (cnt == 6) return 1;
		else if (cnt == 5) return 2;
		else if (cnt == 4) return 3;
		else if (cnt == 3) return 4;
		else if (cnt == 2) return 5;
		else return 6;
	}
}

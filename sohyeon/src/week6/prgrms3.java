package week6;

class Solution {
	public int solution(int left, int right) {
		int answer = 0;
		for(int i = left; i <= right; i++) {
			int cnt = getPrimeNum(i);
			if (cnt % 2 == 0) answer += i;
			else answer -= i;
		}
		return answer;
	}

	private int getPrimeNum(int num) {
		boolean[] visited = new boolean[num+1];
		for(int i = 1; i <= num; i++) {
			if (num % i != 0) continue;
			if (visited[i]) break;
			visited[i] = true;
			visited[num/i] = true;
		}

		int cnt = 0;
		for (int i = 0; i < visited.length; i++) {
			if (visited[i]) cnt++;
		}
		return cnt;
	}
}

public class prgrms3 {
}

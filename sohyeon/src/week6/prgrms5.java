package week6;

public class prgrms5 {
	public int solution(int[] a, int[] b) {
		int answer = 0;
		for (int i = 0; i < a.length; i++) {
			answer += a[i]*b[i];
		}
		return answer;
	}
}

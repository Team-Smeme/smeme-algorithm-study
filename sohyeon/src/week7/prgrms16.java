package week7;

import java.util.*;

public class prgrms16 {
	public int solution(int[] A, int[] B) {

		Arrays.sort(A);
		Arrays.sort(B);

		int answer = 0;

		for (int i = 0; i < A.length; i++) {
			answer += A[i] * B[B.length - i - 1];
		}

		return answer;
	}
}

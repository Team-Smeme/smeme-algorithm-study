package week7;

import java.util.*;


public class prgrms08 {
	public int solution(int n, int[] lost, int[] reserve) {

		int[] arr = new int[n+1];

		for (int i = 1; i <= n; i++) {
			arr[i] = 1;
		}

		for (int i = 0; i < lost.length; i++) {
			arr[lost[i]]--;
		}

		for (int i = 0; i < reserve.length; i++) {
			arr[reserve[i]]++;
		}

		for (int i = 1; i <= n; i++) {
			if (arr[i] >= 1) continue;
			if (i-1 >= 0 && i+1 <= n) {
				if (arr[i-1] >= 2 && arr[i+1] >= 2) continue;
				if (arr[i-1] >= 2 && arr[i+1] < 2) {
					arr[i]++;
					arr[i-1]--;
				} else if (arr[i-1] < 2 && arr[i+1] >= 2) {
					arr[i]++;
					arr[i+1]--;
				}
			}
			else if (i-1 >= 0 && i+1 > n && arr[i-1] >= 2) {
				arr[i]++;
				arr[i-1]--;
			}
			else if (i-1 < 0 && i+1 <= n && arr[i+1] >= 2) {
				arr[i]++;
				arr[i+1]--;
			}
		}

		for (int i = 1; i <= n; i++) {
			if (arr[i] != 0) continue;

			if (i-1 >= 0 && arr[i-1] >= 2) {
				arr[i]++;
				arr[i-1]--;
			} else if (i+1 <= n && arr[i+1] >= 2) {
				arr[i]++;
				arr[i+1]--;
			}
		}

		System.out.println(Arrays.toString(arr));

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			if (arr[i] > 0) answer++;
		}


		return answer;
	}
}

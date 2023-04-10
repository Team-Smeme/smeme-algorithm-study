package week6;

import java.util.*;

public class prgms2 {

	static Queue<long[]> queue = new LinkedList<>();
	static long maxX = Long.MIN_VALUE;
	static long minX = Long.MAX_VALUE;
	static long maxY = Long.MIN_VALUE;
	static long minY = Long.MAX_VALUE;

	public String[] solution(int[][] line) {

		for(int i = 0; i < line.length; i++) {
			for (int j = i; j < line.length; j++) {
				if (i == j) continue;
				getPoint(line[i], line[j]);
			}
		}

		long n = maxY - minY + 1;
		long m = maxX - minX + 1;

		String[][] board = new String[(int)n][(int)m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = ".";
			}
		}

		long tempY = (-1) * minY;
		long tempX = (-1) * minX;

		while(!queue.isEmpty()) {
			long[] point = queue.remove();
			long x = point[0];
			long y = point[1];
			board[(int)(y+tempY)][(int)(x+tempX)] = "*";
		}

		String[] answer = new String[(int)n];
		int cnt = 0;
		for (int i = (int)(n-1); i >= 0; i--) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < (int)m; j++) {
				sb.append(board[i][j]);
			}
			answer[cnt++] = sb.toString();
		}

		return answer;
	}

	private void getPoint(int[] p, int[] q) {
		long a = p[0];
		long b = p[1];
		long c = p[2];
		long d = q[0];
		long e = q[1];
		long f = q[2];

		if (a*e == b*d) return;

		long x1 = b*f - c*e;
		long x2 = a*e - b*d;
		if (x2 == 0 || x1 % x2 != 0) return;
		long x = x1/x2;

		long y1 = a*f - c*d;
		long y2 = b*d - a*e;
		if (y2 == 0 || y1 % y2 != 0) return;
		long y = y1/y2;

		maxX = Math.max(maxX, x);
		minX = Math.min(minX, x);
		maxY = Math.max(maxY, y);
		minY = Math.min(minY, y);

		queue.add(new long[] {x, y});
	}
}



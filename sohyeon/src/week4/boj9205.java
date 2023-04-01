package week4;

import java.util.*;
import java.io.*;

class Position {
	int x;
	int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class boj9205 {

	static int T, N;
	static Queue<Position> beers;
	static ArrayList<Position> al;
	static int sx, sy, dx, dy;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());

			al = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				al.add(new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());

			System.out.println(getResult());
		}

	}

	static String getResult() {
		beers = new LinkedList<>();
		boolean[] visited = new boolean[al.size()];

		beers.add(new Position(sx, sy));

		while (!beers.isEmpty()) {
			Position now = beers.remove();

			if (getDistance(now, new Position(dx, dy)) <= 20*50) {
				return "happy";
			}

			for (int i = 0; i < al.size(); i++) {
				if (visited[i]) continue;

				if (getDistance(now, al.get(i)) <= 20*50) {
					beers.add(al.get(i));
					visited[i] = true;
				}
			}
		}

		return "sad";
	}

	static int getDistance(Position from, Position to) {
		return Math.abs(from.x - to.x) + Math.abs(from.y - to.y);
	}
}

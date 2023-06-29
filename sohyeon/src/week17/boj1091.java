package week17;

import java.io.*;
import java.util.*;

public class boj1091 {

	static int N;
	static int[] P, S;
	static ArrayList<ArrayList<Integer>> al;
	static int res = 0;
	static int[] card;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		P = new int[N];
		S = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}

		al = new ArrayList<>();

		for (int i = 0; i < 3; i++) al.add(new ArrayList<>());

		for (int i = 0; i < N; i++) {
			al.get(P[i]).add(S[i]);
		}

		card = new int[N];
		System.arraycopy(S, 0, card, 0, N);

		while (!check()) {
			if (!mix()) {
				res = -1;
				break;
			}
		}

		System.out.println(res);

	}

	private static boolean mix() {
		int[] temp = new int[N];

		for (int i = 0; i < N; i++) {
			int pos = S[i];
			int num = card[i];
			temp[pos] = num;
		}

		System.arraycopy(temp, 0, card, 0, N);

		res++;

		for (int i = 0; i < N; i++) {
			if (card[i] != S[i]) return true;
		}

		return false;
	}

	private static boolean check() {
		for (int i = 0; i < N; i++) {
			int num = card[i];
			int player = i % 3;
			if (!al.get(player).contains(num)) return false;
		}
		return true;
	}
}

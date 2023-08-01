package week22;


import java.io.*;
import java.util.*;

public class boj7662 {

	static int NUM;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int k = Integer.parseInt(br.readLine());
			HashMap<Integer, Integer> map = new HashMap<>();
			PriorityQueue<Integer> minPq = new PriorityQueue<>();
			PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
			while (k-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if (cmd.equals("I")) {
					map.put(num, map.getOrDefault(num, 0) + 1);
					maxPq.offer(num);
					minPq.offer(num);
				} else  {
					if (map.isEmpty()) continue;
					PriorityQueue<Integer> pq = num == 1 ? maxPq : minPq;
					removePq(pq, map);
				}
			}

			if (map.isEmpty() || (maxPq.isEmpty() && minPq.isEmpty()))
				System.out.println("EMPTY");
			else {
				removePq(maxPq, map);
				if (map.isEmpty())
					System.out.println(NUM + " " + NUM);
				else {
					int temp = NUM;
					removePq(minPq, map);
					System.out.println(temp + " " + NUM);
				}
			}
		}

	}

	private static void removePq(PriorityQueue<Integer> pq, HashMap<Integer, Integer> map) {
		while (!pq.isEmpty()) {
			int num = pq.poll();
			int cnt = map.getOrDefault(num, 0);
			if (cnt == 0)
				continue;
			else if (cnt == 1)
				map.remove(num);
			else
				map.put(num, map.get(num) - 1);
			NUM = num;
			return;
		}
	}

}

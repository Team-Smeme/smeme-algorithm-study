package week11;

import java.util.*;
import java.io.*;

public class boj13335 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		Queue<Integer> truck = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			truck.offer(Integer.parseInt(st.nextToken()));
		}

		Queue<Integer> queue = new LinkedList<>();
		int time = 0;
		int bw = 0;
		for (int i = 0; i < w; i++) {
			queue.offer(0);
		}

		while (!queue.isEmpty()) {
			time++;
			bw -= queue.poll();
			if (!truck.isEmpty()) {
				if (truck.peek() + bw <= l) {
					bw += truck.peek();
					queue.offer(truck.poll());
				} else {
					queue.offer(0);
				}
			}
		}

		System.out.println(time);

	}
}

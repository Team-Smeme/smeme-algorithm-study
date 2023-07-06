package week18;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class boj2884 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		LocalDateTime alarm = LocalDateTime.of(2000, 10, 10, h, m, 0).minusMinutes(45);

		System.out.println(alarm.getHour() + " " + alarm.getMinute());

	}
}

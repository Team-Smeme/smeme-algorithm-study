package 자료구조.큐;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class 카드2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            queue.offer(queue.poll());
        }

        bw.write(String.valueOf(queue.poll()));
        bw.flush();
        bw.close();
    }
}
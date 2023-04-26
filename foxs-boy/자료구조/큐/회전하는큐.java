package 자료구조.큐;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 회전하는큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        LinkedList<Integer> deque = new LinkedList<>();

        int count = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int[] seq = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {

            int target_index = deque.indexOf(seq[i]);
            int half_index;

            if (deque.size() % 2 == 0) half_index = deque.size() / 2 - 1;
            else half_index = deque.size() / 2;

            if (target_index <= half_index) {

                for (int j = 0; j < target_index; j++) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    count++;
                }
            } else {

                for (int j = 0; j < deque.size() - target_index; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    count++;
                }
            }
            deque.pollFirst();

        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();

    }
}

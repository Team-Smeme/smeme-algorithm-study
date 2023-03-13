package 구현;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스문제0 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> q = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        while (q.size() > 1) {
            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }

            sb.append(q.poll()).append(", ");
        }

        sb.append(q.poll()).append('>');
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }

}

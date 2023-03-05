package 수학;

import java.io.*;
import java.util.StringTokenizer;

public class ACM호텔 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb;
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int a = N % H; //나머 지
            int b = N / H; //몫

            if (a == 0) {
                sb.append((H * 100) + b);
            } else {
                sb.append((a * 100) + (b + 1));
            }

            bw.write(sb + "\n");
        }
        br.close();
        bw.flush();
        bw.close();

    }
}

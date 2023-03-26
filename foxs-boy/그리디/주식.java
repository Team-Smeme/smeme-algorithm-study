package 그리디;

import java.io.*;
import java.util.StringTokenizer;

public class 주식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (T > 0) {
            int N = Integer.parseInt(br.readLine());
            long profit = 0;
            long[] arr = new long[N];
            long max = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] > max) {
                    max = arr[i];
                } else {
                    profit += (max - arr[i]);
                }
            }

            bw.write(profit + "\n");
            T--;
        }
        bw.flush();
        bw.close();


    }
}

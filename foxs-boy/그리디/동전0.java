package 그리디;

import java.io.*;
import java.util.StringTokenizer;

public class 동전0 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] <= K) {
                count += K / arr[i];
                K = K % arr[i];
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();

    }
}



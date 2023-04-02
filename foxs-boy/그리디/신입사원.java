package 그리디;

import java.io.*;
import java.util.StringTokenizer;

public class 신입사원 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int rank = Integer.parseInt(st.nextToken());
                arr[rank] = Integer.parseInt(st.nextToken());
            }

            int ans = 1;
            int min = arr[1];

            for (int j = 2; j <= N; j++) {
                if (arr[j] < min) {
                    ans++;
                    min = arr[j];
                }
            }

            bw.write(ans + "\n");


            T--;
        }
        bw.flush();
        bw.close();

    }
}


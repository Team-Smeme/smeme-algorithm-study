package 그래프;

import java.io.*;
import java.util.StringTokenizer;

public class 바닥장식 {

    static int N, M;
    static char[][] floor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        floor = new char[N][M];

        int count = 0;

        for (int i = 0; i < N; i++) {
            floor[i] = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                if (floor[i][j] == '-') {
                    count++;
                    while (j < M && floor[i][j] == '-') j++;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (floor[j][i] == '|') {
                    count++;
                    while (j < N && floor[j][i] == '|') j++;
                }
            }
        }
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();

    }

}

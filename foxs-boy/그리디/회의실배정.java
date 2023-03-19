package 그리디;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실배정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];


        StringTokenizer st;

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int end_time = 0;

        for (int i = 0; i < N; i++) {
            if (end_time <= time[i][0]) {
                end_time = time[i][1];
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();


    }
}

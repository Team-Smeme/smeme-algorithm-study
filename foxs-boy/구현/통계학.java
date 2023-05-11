package 구현;

import java.io.*;

public class 통계학 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[8001];
        int num;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int median = 10000;
        int mode = 10000;

        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());
            sum += num;
            arr[num + 4000]++;

            if (max < num) max = num;
            if (min > num) min = num;
        }

        int count = 0;
        int mode_max = 0;

        boolean flag = false;

        for (int i = min + 4000; i <= max + 4000; i++) {
            if (arr[i] > 0) {
                if (count < (N + 1) / 2) {
                    count += arr[i];
                    median = i - 4000;
                }

                if (mode_max < arr[i]) {
                    mode_max = arr[i];
                    mode = i - 4000;
                    flag = true;

                } else if (mode_max == arr[i] && flag) {
                    mode = i - 4000;
                    flag = false;
                }
            }

        }

        bw.write(String.valueOf((int)Math.round((double)sum) / N) + '\n');
        bw.write(String.valueOf(median) + '\n');
        bw.write(String.valueOf(mode) + '\n');
        bw.write(String.valueOf(max - min));
        bw.flush();
        bw.close();


    }
}

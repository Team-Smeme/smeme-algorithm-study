package 그리디;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int personNumber = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[personNumber];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] prefix_sum = new int[personNumber + 1];

        for (int i = 1; i < arr.length + 1; i++) {
            prefix_sum[i] += prefix_sum[i - 1] + arr[i - 1];
        }

        int sum = 0;

        for (int i = 1; i < arr.length + 1; i++) {
            sum += prefix_sum[i];
        }

        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();


    }
}

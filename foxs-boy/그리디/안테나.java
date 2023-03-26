package 그리디;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// boj 18310
public class 안테나 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        if (N % 2 == 0) {
            bw.write(String.valueOf(arr[N / 2 - 1]));
        } else {
            bw.write(String.valueOf(arr[N / 2]));
        }
        bw.flush();
        bw.close();


    }
}

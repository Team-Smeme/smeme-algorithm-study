package 그리디;

import java.io.*;

public class 설탕배달 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if (N == 4 || N == 7) {
            bw.write(String.valueOf(-1));
        } else if (N % 5 == 0) {
            bw.write(String.valueOf(N / 5));
        } else if (N % 5 == 1 || N % 5 == 3) {
            bw.write(String.valueOf((N / 5) + 1));
        } else if (N % 5 == 2 || N % 5 == 4) {
            bw.write(String.valueOf((N / 5) + 2));
        }
        bw.flush();
        bw.close();

    }
}

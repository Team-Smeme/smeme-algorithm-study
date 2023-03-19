package 그리디;

import java.io.*;
import java.util.StringTokenizer;

public class 잃어버린괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = Integer.MAX_VALUE;
        StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-");

        while (subtraction.hasMoreTokens()) {
            int temp = 0;

            StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+");

            while (addition.hasMoreTokens()) {
                temp += Integer.parseInt(addition.nextToken());
            }

            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }

        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}

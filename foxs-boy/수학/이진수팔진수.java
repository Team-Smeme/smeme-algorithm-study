package 수학;

import java.io.*;

public class 이진수팔진수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int length = str.length();
        if (length % 3 == 1) {
            bw.write(String.valueOf(str.charAt(0)));
        } else if (length % 3 == 2) {
            bw.write(String.valueOf((str.charAt(0) - '0') * 2 + (str.charAt(1) - '0')));
        }

        for (int i = length % 3; i < length; i += 3) {
            bw.write(String.valueOf((str.charAt(i) - '0') * 4 + (str.charAt(i + 1) - '0') * 2 + (str.charAt(i + 2) - '0')));
        }
        br.close();
        bw.flush();
        bw.close();
    }
}

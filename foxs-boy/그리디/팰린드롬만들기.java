package 그리디;

import java.io.*;

public class 팰린드롬만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int[] alpha = new int[26];

        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'A';
            alpha[index]++;
        }


        int isOne = 0;
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] % 2 != 0) isOne++;
        }

        String answer = "";
        StringBuilder sb = new StringBuilder();
        if (isOne > 1) answer += "I'm Sorry Hansoo";
        else {

            for (int i = 0; i < alpha.length; i++) {
                for (int j = 0; j < alpha[i] / 2; j++) {
                    sb.append((char) (i + 65));
                }
            }

            answer += sb.toString();
            String end = sb.reverse().toString();

            sb = new StringBuilder();
            for (int i = 0; i < alpha.length; i++) {
                if (alpha[i] % 2 == 1) {
                    sb.append((char) (i + 65));
                }
            }

            answer += sb.toString() + end;

        }

        bw.write(answer);
        bw.flush();
        bw.close();


    }
}

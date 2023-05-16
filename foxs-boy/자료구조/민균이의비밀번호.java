package 자료구조;

import java.io.*;
import java.util.ArrayList;

public class 민균이의비밀번호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String reverseStr = new StringBuffer(str).reverse().toString();

            if (list.contains(reverseStr) || str.equals(reverseStr)) {
                bw.write(str.length() + " " + str.charAt((str.length()) / 2));
                bw.flush();
                bw.close();
                return;
            } else {
                list.add(str);
            }
        }

    }
}

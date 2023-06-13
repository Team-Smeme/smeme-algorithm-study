package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 뒤집기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        check(str);
    }

    static void check(String str) {
        int count = 0;
        char c = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (c != str.charAt(i)) {
                c = str.charAt(i);
                count++;
            }
        }
        System.out.println((count / 2) + count % 2);
    }
}

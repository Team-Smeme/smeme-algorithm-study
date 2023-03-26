package 자료구조.스택;

import java.io.*;
import java.util.Stack;

public class 안정적인문자열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int no = 1;

        while (true) {

            String str = br.readLine();
            if (str.contains("-")) break;

            int count = 0;
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                char temp = str.charAt(i);
                if (temp == '{') {
                    stack.add(temp);
                } else {
                    if (stack.empty()) {
                        count++;
                        stack.add('{');
                    } else {
                        stack.pop();
                    }
                }
            }
            bw.write((no++) + ". " + (count + stack.size() / 2) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}

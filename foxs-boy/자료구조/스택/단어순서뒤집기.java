package 자료구조.스택;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 단어순서뒤집기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        int count = 1;

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Stack<String> stack = new Stack<>();

            while (st.hasMoreTokens()) {
                stack.push(st.nextToken());
            }

            bw.write("Case #" + (count) + ": ");
            while (!stack.isEmpty()) {
                bw.write(stack.pop() + " ");
            }
            bw.write('\n');
            count++;
        }
        bw.flush();
        bw.close();

    }
}

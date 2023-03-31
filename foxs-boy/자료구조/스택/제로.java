package 자료구조.스택;

import java.io.*;
import java.util.Stack;

public class 제로 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        int num;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i++) {

            num = Integer.parseInt(br.readLine());
            if (num != 0) {
                stack.push(num);
            } else {
                stack.pop();
            }

        }

        long sum = 0;
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            sum += stack.pop();
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();


    }
}

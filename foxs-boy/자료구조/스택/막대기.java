package 자료구조.스택;

import java.io.*;
import java.util.Stack;

public class 막대기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int num;
        int count = 1;

        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());
            stack.push(num);
        }

        int standard = stack.pop();
        int current;

        while (!stack.isEmpty()) {
            current = stack.pop();
            if (current > standard) {
                count++;
                standard = current;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}

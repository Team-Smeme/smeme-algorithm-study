package 자료구조.스택;

import java.io.*;
import java.util.Objects;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringTokenizer st;
        int peek;
        String order;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            order = st.nextToken();
            if (Objects.equals(order, "push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (Objects.equals(order, "pop")) {
                if (stack.empty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(stack.pop() + "\n");
                }
            } else if (Objects.equals(order, "size")) {

                bw.write(stack.size() + "\n");
            } else if (Objects.equals(order, "empty")) {
                if (stack.empty()) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            } else if (Objects.equals(order, "top")) {
                if (stack.empty()) {
                    bw.write(-1 + "\n");
                } else {
                    peek = stack.peek();
                    bw.write(peek + "\n");
                }
            }

        }

        bw.flush();
        bw.close();

    }
}

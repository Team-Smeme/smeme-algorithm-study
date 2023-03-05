package 수학;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 쉽게푸는문제 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        int num = 1;

        while (list.size() <= 1000) {
            for (int i = num; i > 0; i--) {
                list.add(num);
            }
            num++;
        }
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = start - 1; i < end; i++) {
            sum += list.get(i);
        }
        br.close();
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();

    }
}

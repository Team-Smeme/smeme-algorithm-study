package 자료구조;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 줄세우기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        list.add(-1);

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(i - num, i);

        }

        for (int i = 1; i <= N; i++) bw.write(list.get(i) + " ");

        br.close();
        bw.flush();
        bw.close();


    }
}

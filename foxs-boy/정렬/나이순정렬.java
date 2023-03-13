package 정렬;

import java.io.*;
import java.util.StringTokenizer;

public class 나이순정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        StringBuilder[] p = new StringBuilder[201];

        for (int i = 0; i < p.length; i++) {
            p[i] = new StringBuilder();
        }

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            p[age].append(age).append(' ').append(name).append("\n");
        }

        StringBuilder sb = new StringBuilder();

        for (StringBuilder val : p) {
            sb.append(val);
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}

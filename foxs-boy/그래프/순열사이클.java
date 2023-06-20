package 그래프;

import java.io.*;
import java.util.StringTokenizer;

public class 순열사이클 {

    static int[] map;
    static boolean[] check;
    static int cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            map = new int[n + 1];
            cycle = 0;
            st = new StringTokenizer(br.readLine());

            for (int i = 1; i < n + 1; i++) map[i] = Integer.parseInt(st.nextToken());

            check = new boolean[n + 1];
            for (int i = 1; i < n + 1; i++) {
                if (!check[i]) {
                    dfs(i);
                    cycle++;
                }
            }
            bw.write(String.valueOf(cycle)+'\n');

        }
        bw.flush();
        bw.close();

    }

    static void dfs(int start) {
        check[start] = true;

        int next = map[start];
        if (!check[next]) {
            dfs(map[start]);
        }

    }
}

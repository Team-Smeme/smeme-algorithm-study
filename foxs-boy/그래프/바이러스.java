package 그래프;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바이러스 {

    static boolean[] check;
    static int[][] arr;
    static int count = 0;

    static int node, line;

    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        arr = new int[node + 1][node + 1];
        check = new boolean[node + 1];

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        dfs(1);

        bw.write(String.valueOf(count - 1));
        bw.flush();
        bw.close();

    }

    private static void dfs(int start) {

        check[start] = true;
        count++;

        for (int i = 0; i <= node; i++) {
            if (arr[start][i] == 1 && !check[i]) dfs(i);
        }
    }
}

package 정렬;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 숫자카드2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());


        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());

            bw.write(map.getOrDefault(key, 0) + " ");
        }

        bw.flush();
        bw.close();


    }
}

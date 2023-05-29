package 이분탐색;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CD {
    static int n, m, count;
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            set = new HashSet<>();
            count = 0;

            for (int i = 0; i < n; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }

            for (int j = 0; j < m; j++) {
                int cd = Integer.parseInt(br.readLine());

                if (set.contains(cd)) {
                    count++;
                }

            }
            bw.write(String.valueOf(count)+"\n");
        }
        bw.flush();
        bw.close();

    }
}

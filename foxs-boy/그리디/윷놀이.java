package 그리디;

import java.io.*;
import java.util.StringTokenizer;

public class 윷놀이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = 3;

        while (T-- > 0) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 4; i++) {
                count += Integer.parseInt(st.nextToken());
            }

            if (count == 0) {
                bw.write("D");
            } else if (count == 1) {
                bw.write("C");
            } else if (count == 2) {
                bw.write("B");
            } else if (count == 3) {
                bw.write("A");
            } else if (count == 4) {
                bw.write("E");
            }

            bw.write('\n');
        }

        bw.flush();
        bw.close();


    }
}

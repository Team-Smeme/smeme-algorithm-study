package 구현;

import java.io.*;
import java.util.StringTokenizer;

public class 집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int S = 0;
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (count-- > 0) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("all")) S = (1 << 21) - 1;
            else if (str.equals("empty")) S = 0;
            else {
                int num = Integer.parseInt(st.nextToken());
                if (str.equals("add"))
                    S |= (1 << num);
                else if (str.equals("remove"))
                    S &= ~(1 << num);
                else if (str.equals("check"))
                    sb.append((S & (1 << num)) != 0 ? 1 : 0).append("\n");
                else if (str.equals("toggle"))
                    S ^= (1 << num);

            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }
}

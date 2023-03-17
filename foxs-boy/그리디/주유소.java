package 그리디;

import java.io.*;
import java.util.StringTokenizer;

public class 주유소 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer cityCount = Integer.parseInt(br.readLine());

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        long[] loadLen = new long[cityCount - 1];
        for (int i = 0; i < loadLen.length; i++) {
            loadLen[i] = Long.parseLong(st.nextToken());
        }

        long price = 0;
        st = new StringTokenizer(br.readLine());

        long[] oilPrice = new long[cityCount - 1];
        for (int i = 0; i < oilPrice.length; i++) {
            oilPrice[i] = Long.parseLong(st.nextToken());
            if (i != 0 && oilPrice[i] > oilPrice[i - 1]) {
                oilPrice[i] = oilPrice[i - 1];
            }
            price += oilPrice[i] * loadLen[i];
        }
        st.nextToken();

        br.close();
        bw.write(String.valueOf(price));
        bw.flush();
        bw.close();


    }
}

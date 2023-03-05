package 수학;

import java.io.*;
import java.util.StringTokenizer;

public class 지능형기차2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int max = 0;
        int numberOfPerson = 0;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            numberOfPerson = numberOfPerson - Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            if (numberOfPerson >= max) {
                max = numberOfPerson;
            }
        }
        br.close();
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();

    }
}

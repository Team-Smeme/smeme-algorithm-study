import java.io.*;
import java.util.StringTokenizer;

public class 지능형기차 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int out_person, in_person;

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            out_person = Integer.parseInt(st.nextToken());
            in_person = Integer.parseInt(st.nextToken());

            sum = sum + in_person - out_person;
            if (sum > max) max = sum;
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();

    }
}

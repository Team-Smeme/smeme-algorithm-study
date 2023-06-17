import java.io.*;
import java.util.StringTokenizer;

public class 분산처리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int a, b;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            int result = 1;

            for (int i = 1; i <= b; i++) result = result * a % 10;
            result = result == 0 ? 10 : result;
            bw.write(String.valueOf(result) + '\n');
        }
        bw.flush();
        bw.close();

    }
}

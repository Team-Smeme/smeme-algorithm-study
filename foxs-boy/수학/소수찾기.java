import java.io.*;
import java.util.StringTokenizer;

public class 소수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            boolean isPrime = true;

            int num = Integer.parseInt(st.nextToken());
            if (num == 1) {
                continue;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();

    }
}

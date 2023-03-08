import java.io.*;
import java.util.StringTokenizer;

public class 최대공약수최소공배수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int d = gcd(A, B);

        bw.write(d + "\n");
        bw.write(String.valueOf(A * B / d));
        bw.flush();
        bw.close();

    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;

        }

        return gcd(b, a % b);
    }
}

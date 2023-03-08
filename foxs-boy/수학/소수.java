import java.io.*;

public class 소수 {

    public static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        prime = new boolean[N + 1];
        get_prime();

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = M; i <= N; i++) {
            if (!prime[i]) {
                sum += i;
                if (min == Integer.MAX_VALUE) min = i;
            }
        }
        br.close();

        if (sum != 0) {
            bw.write(sum + "\n");
            bw.write(String.valueOf(min));
        } else {
            bw.write(String.valueOf(-1));
        }

        bw.flush();
        bw.close();

    }

    public static void get_prime() {
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) continue;
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}

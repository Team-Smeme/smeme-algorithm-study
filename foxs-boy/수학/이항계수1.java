import java.io.*;
import java.util.StringTokenizer;

public class 이항계수1 {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][K + 1];
        br.close();
        bw.write(String.valueOf(BC(N, K)));
        bw.flush();
        bw.close();

    }

    static int BC(int n, int k) {
        if (dp[n][k] > 0) {
            return dp[n][k];
        }

        if (k == 0 || n == k) {
            return dp[n][k] = 1;
        }

        return dp[n][k] = BC(n - 1, k - 1) + BC(n - 1, k);
    }


}

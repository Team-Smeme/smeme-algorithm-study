import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GCD합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseCount; i++) {
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int numCount = Integer.parseInt(st.nextToken());
            for (int j = 0; j < numCount; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            for (int a = 0; a < list.size() - 1; a++) {
                for (int b = a + 1; b < list.size(); b++) {
                    sum += gcd(list.get(a), list.get(b));
                }
            }
            bw.write(sum + "\n");

        }
        bw.flush();
        bw.close();

    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }

}

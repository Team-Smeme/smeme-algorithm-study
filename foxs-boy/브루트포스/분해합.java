import java.io.*;

public class 분해합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int result=0;

        for (int i = 0; i < num; i++) {
            int number = i;
            int sum = 0;

            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }

            if (sum + i == num) {
                result = i;
                break;
            }
        }
        bw.write(String.valueOf(result));

        br.close();
        bw.flush();
        bw.close();

    }
}

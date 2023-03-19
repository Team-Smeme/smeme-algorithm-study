import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class 셀프넘버 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] check = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            int n = count(i);

            if (n < 10001) {
                check[n] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 10001; i++) {
            if (!check[i]) {
                sb.append(i).append("\n");
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();


    }

    public static int count(int number) {
        int sum = number;

        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}

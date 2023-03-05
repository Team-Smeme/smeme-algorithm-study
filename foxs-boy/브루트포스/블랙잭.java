import java.io.*;
import java.util.StringTokenizer;

public class 블랙잭 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int number = Integer.parseInt(st.nextToken());
        int[] arr = new int[count];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < count - 2; i++) {
            for (int j = i + 1; j < count - 1; j++) {
                for (int k = j + 1; k < count; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum >= max && sum <= number) {
                        max = sum;
                    }
                }
            }
        }
        br.close();
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();

    }
}

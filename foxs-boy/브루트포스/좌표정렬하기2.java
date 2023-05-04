import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좌표정렬하기2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][0] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (e1, e2) -> {
            if (e1[0] == e2[0]) {
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i][1]).append(" ").append(arr[i][0]).append('\n');
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }
}
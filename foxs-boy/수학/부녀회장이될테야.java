import java.io.*;

public class 부녀회장이될테야 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[15][15];

        for (int i = 0; i < 15; i++) {
            arr[i][1] = 1;
            arr[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {    // 1층부터 14층까지

            for (int j = 2; j < 15; j++) {    // 2호부터 14호까지
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            bw.write(arr[k][n] + "\n");
        }


        br.close();
        bw.flush();
        bw.close();

    }
}

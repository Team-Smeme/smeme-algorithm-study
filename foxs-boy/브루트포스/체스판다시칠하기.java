import java.io.*;
import java.util.StringTokenizer;

// boj 1018

public class 체스판다시칠하기 {

    public static boolean[][] board;
    public static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();

            for (int j = 0; j < M; j++) {
                if (row.charAt(j) == 'W') {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }

        int N_row = N - 7;
        int M_col = M - 7;

        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                find(i, j);
            }
        }

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();


    }

    public static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean TF = board[x][y]; // 첫 번째 칸의 색

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {

                if (board[i][j] != TF) {
                    count++;
                }

                TF = !TF;
            }

            TF = !TF;
        }

        count = Math.min(count, 64 - count);

        min = Math.min(min, count);

    }
}

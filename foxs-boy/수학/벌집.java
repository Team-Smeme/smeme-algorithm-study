package 수학;

import java.io.*;

public class 벌집 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int shell = 1;
        int i=1;
        int result = 1;
        boolean check = true;

        while (check) {
            if (num - shell > 0) {
                num -= shell;
                i++;
                shell = 6*(i-1);
                result += 1;
            } else {
                check = false;
            }
        }
        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
        bw.close();

    }
}

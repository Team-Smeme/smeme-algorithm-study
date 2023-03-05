import java.io.*;

public class 팰린드롬수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num;
        while ((num = Integer.parseInt(br.readLine())) != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(num);
            if (sb.toString().equals(sb.reverse().toString())) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}

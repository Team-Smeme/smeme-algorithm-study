import java.io.*;
import java.math.BigInteger;

public class Hashing {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int r = 31;
        int M = 1234567891;
        BigInteger hash = new BigInteger("0");

        int length = Integer.parseInt(br.readLine());
        String str = br.readLine();

        for (int i = 0; i < length; i++) {
            hash = hash.add(BigInteger.valueOf(str.charAt(i) - 96).multiply(BigInteger.valueOf(31).pow(i)));
        }

        br.close();
        bw.write(String.valueOf(hash.remainder(BigInteger.valueOf(M))));
        bw.flush();
        bw.close();
    }
}

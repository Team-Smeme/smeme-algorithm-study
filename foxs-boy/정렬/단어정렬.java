package 정렬;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class 단어정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        String[] arr = new String[count];

        for (int i = 0; i < count; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                } else {
                    return s1.length() - s2.length();
                }
            }
        });

        bw.write(arr[0] + "\n");
        for (int i = 1; i < count; i++) {
            if (!arr[i].equals(arr[i - 1])) {
                bw.write(arr[i] + "\n");
            }
        }

        bw.flush();
        bw.close();


    }
}

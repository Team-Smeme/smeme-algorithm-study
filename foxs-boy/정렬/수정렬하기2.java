package 정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class 수정렬하기2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        for (int value : list) {
            bw.write(value + "\n");
        }
        bw.flush();
        bw.close();
    }
}

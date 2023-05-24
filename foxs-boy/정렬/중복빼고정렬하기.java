package 정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 중복빼고정렬하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> arrayList = new ArrayList<Integer>(set);
        Collections.sort(arrayList);

        for (int i : arrayList) {
            sb.append(i).append(" ");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }
}

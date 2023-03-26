package 그리디;

// boj 12018

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class YonseiTOTO {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int subject_number = Integer.parseInt(st.nextToken());
        int mileage = Integer.parseInt(st.nextToken());
        int[] min_arr = new int[subject_number];

        for (int i = 0; i < subject_number; i++) {
            st = new StringTokenizer(br.readLine());
            int apply_num = Integer.parseInt(st.nextToken());
            int limit_num = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            if (apply_num > limit_num) {
                int[] sub = new int[apply_num];
                for (int j = 0; j < apply_num; j++) {
                    sub[j] = Integer.parseInt(st.nextToken());
                }
                Arrays.sort(sub);
                min_arr[i] = sub[apply_num - limit_num];
            } else {
                min_arr[i] = 1;
            }
        }

        Arrays.sort(min_arr);
        int max_subject = 0;
        for (int i = 0; i < subject_number; i++) {
            if (min_arr[i] > mileage) break;
            mileage -= min_arr[i];
            max_subject++;
        }
        bw.write(String.valueOf(max_subject));
        bw.flush();
        bw.close();


    }
}



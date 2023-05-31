package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드1 {
    public static void main(String args[]) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 1; i <= n; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            sb.append(q.poll()).append(" ");
            if(q.isEmpty()) {
                break;
            }
            q.offer(q.poll());
        }

        System.out.println(sb.toString());
    }
}
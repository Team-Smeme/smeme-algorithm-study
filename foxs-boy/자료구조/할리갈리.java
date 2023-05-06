package 자료구조;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class 할리갈리 {

    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String a = kb.next();
            int b = kb.nextInt();
            map.put(a, map.getOrDefault(a, 0) + b);
        }
        String answer = "NO";
        for (String key : map.keySet()) {
            if (map.get(key) == 5) answer = "YES";
        }
        System.out.println(answer);
    }
}
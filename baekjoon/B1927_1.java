package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B1927_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();

            if (x == 0) {
                Integer y = pq.poll();
                if (y == null) sb.append(0).append('\n');
                else sb.append(y).append('\n');
                continue;
            }

            pq.add(x);
        }

        System.out.println(sb);
    }
}

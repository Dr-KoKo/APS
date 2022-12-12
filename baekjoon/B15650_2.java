package baekjoon;

import java.util.Scanner;

public class B15650_2 {
    private static int N, M;
    private static int[] ans;
    private static boolean[] visited;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        M = input.nextInt();
        visited = new boolean[N + 1];
        ans = new int[M];

        rec(0, 0);

        System.out.print(sb);
    }

    private static void rec(int k, int b) {
        if (k == M) {
            for (int an : ans) {
                sb.append(an).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int cand = b + 1; cand <= N; cand++) {
            if (!visited[cand]) {
                ans[k] = cand;
                visited[cand] = true;

                rec(k + 1, cand);

                ans[k] = 0;
                visited[cand] = false;
            }

        }

    }

}
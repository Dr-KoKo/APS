package baekjoon;

import java.util.Scanner;

public class B15651_2 {
    private static int N, M;
    private static int[] ans;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        M = input.nextInt();
        ans = new int[M];

        rec(0);

        System.out.print(sb);
    }

    private static void rec(int k) {
        if (k == M) {
            for (int an : ans) {
                sb.append(an).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int cand = 1; cand <= N; cand++) {
            ans[k] = cand;

            rec(k + 1);

            ans[k] = 0;
        }

    }
}
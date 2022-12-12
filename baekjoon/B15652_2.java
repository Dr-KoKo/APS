package baekjoon;

import java.util.Scanner;

public class B15652_2 {
    private static int N, M;
    private static int[] ans;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        M = input.nextInt();
        ans = new int[M];

        rec(0, 1);

        System.out.print(sb);
    }

    private static void rec(int k, int b) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(ans[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int cand = b; cand <= N; cand++) {
            ans[k] = cand;

            rec(k + 1, cand);

            ans[k] = 0;
        }

    }
}
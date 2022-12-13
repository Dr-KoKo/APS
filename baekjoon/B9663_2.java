package baekjoon;

import java.util.Scanner;

public class B9663_2 {
    private static int N, ans;
    private static int[] col;

    public static void main(String[] args) {
        init();
        rec(1);
        print();
    }

    private static void print() {
        System.out.println(ans);
    }

    private static void rec(int row) {
        if (row == N + 1) {
            ans++;
            return;
        }

        for (int c = 1; c <= N; c++) {
            boolean possible = true;
            for (int i = 1; i < row; i++) {
                if (attackable(row, c, i, col[i])) {
                    possible = false;
                }
            }

            if (possible) {
                col[row] = c;
                rec(row + 1);
                col[row] = 0;
            }
        }
    }

    private static boolean valid() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (attackable(i, col[i], j, col[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true;
        if (r1 - c1 == r2 - c2) return true;
        if (r1 + c1 == r2 + c2) return true;
        return false;
    }

    private static void init() {
        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        col = new int[N + 1];
        ans = 0;

        input.close();
    }
}

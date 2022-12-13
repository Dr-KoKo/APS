package baekjoon;

import java.util.Scanner;

public class B1182_1 {
    private static int N, S, ans;
    private static int[] nums;

    public static void main(String[] args) {
        init();
        rec(1, 0);
        if(S==0) ans--;
        print();
    }

    private static void print() {
        System.out.println(ans);
    }

    private static void rec(int k, int value) {
        if (k == N + 1) {
            if(value==S) ans++;
            return;
        }

        rec(k+1, value+nums[k]);
        rec(k+1, value);
    }

    private static void init() {
        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        S = input.nextInt();
        ans = 0;
        nums = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            nums[i] = input.nextInt();
        }

        input.close();
    }
}

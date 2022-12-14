package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B1015_1 {
    private static int N;
    private static int[] nums, sorted, ans;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        generateAns();
        print();
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append(' ');
        }
        System.out.println(sb);
    }

    private static void generateAns() {
        Arrays.sort(sorted);

        for (int i = 0; i < N; i++) {
            int idx = -1;
            for (int j = N - 1; j >= 0; j--) {
                if (nums[i] == sorted[j]) {
                    idx = j;
                }
            }
            sorted[idx] = -1;
            ans[i] = idx;
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        nums = new int[N];
        sorted = new int[N];
        ans = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
            sorted[i] = nums[i];
        }

        sc.close();
    }
}

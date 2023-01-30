package baekjoon;

import java.util.Scanner;

public class B3003_1 {
    private static final int[] nums = {1, 1, 2, 2, 2, 8};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            sb.append(nums[i] - sc.nextInt()).append(' ');
        }

        System.out.println(sb);
    }
}

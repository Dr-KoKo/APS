package baekjoon;

import java.util.Scanner;

public class B14888_2 {
    private static int N;
    private static int max, min;
    private static int[] nums, ops;


    public static void main(String[] args) throws Exception {
        init();
        rec(1, nums[1]);
        print();
    }

    private static void print() {
        System.out.println(max);
        System.out.println(min);
    }

    private static void rec(int k, int val) throws Exception {
        if (k == N) {
            max = Math.max(max, val);
            min = Math.min(min, val);

            return;
        }

        for (int i = 1; i <= 4; i++) {
            if (ops[i] >= 1) {
                ops[i]--;

                int value = calculate(val, i, nums[k + 1]);
                rec(k + 1, value);

                ops[i]++;
            }
        }

    }

    private static int calculate(int operand1, int op, int operand2) throws Exception {
        if (op == 1) {
            return operand1 + operand2;
        }
        if (op == 2) {
            return operand1 - operand2;
        }
        if (op == 3) {
            return operand1 * operand2;
        }
        if (op == 4) {
            return operand1 / operand2;
        }
        throw new Exception();
    }

    private static void init() {
        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        nums = new int[N + 1];
        ops = new int[5];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            nums[i] = input.nextInt();
        }

        for (int i = 1; i <= 4; i++) {
            ops[i] = input.nextInt();
        }
    }
}

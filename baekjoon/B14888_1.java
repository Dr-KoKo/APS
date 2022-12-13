package baekjoon;

import java.util.Scanner;

public class B14888_1 {
    private static int N;
    private static int max, min;
    private static int[] nums, ops, order;

    public static void main(String[] args) {
        init();
        rec(1);
        print();
    }

    private static void print() {
        System.out.println(max);
        System.out.println(min);
    }

    private static void rec(int k) {
        if (k == N) {
            int value = cal();

            max = Math.max(max, value);
            min = Math.min(min, value);

            return;
        }

        for (int o = 1; o <= 4; o++) {
            if (ops[o] >= 1) {
                order[k] = o;
                ops[o]--;

                rec(k+1);

                order[k] = 0;
                ops[o]++;
            }
        }
    }

    private static int cal() {
        int val = nums[1];

        for(int i = 1; i < N; i++){
            if(order[i]==1){
                val += nums[i+1];
            }
            if(order[i]==2){
                val -= nums[i+1];
            }
            if(order[i]==3){
                val *= nums[i+1];
            }
            if(order[i]==4){
                val /= nums[i+1];
            }
        }

        return val;
    }

    private static void init() {
        Scanner input = new Scanner(System.in);

        N = input.nextInt();

        nums = new int[N + 1];
        ops = new int[5];
        order = new int[N];

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        for (int n = 1; n <= N; n++) {
            nums[n] = input.nextInt();
        }

        for (int o = 1; o <= 4; o++) {
            ops[o] = input.nextInt();
        }
    }

}

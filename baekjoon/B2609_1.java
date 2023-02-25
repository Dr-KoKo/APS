package baekjoon;

import java.util.Scanner;

public class B2609_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int min = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;

        for (int n = 1; n <= num1 * num2; n++) {
            if (num1 % n == 0 && num2 % n == 0) {
                min = Math.max(min, n);
            }

            if (n % num1 == 0 && n % num2 == 0) {
                max = n;
                break;
            }
        }

        System.out.println(min);
        System.out.println(max);
    }
}

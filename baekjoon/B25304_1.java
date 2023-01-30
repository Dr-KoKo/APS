package baekjoon;

import java.util.Scanner;

public class B25304_1 {
    private static int X, sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        X = sc.nextInt();
        sum = 0;

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            sum += sc.nextInt() * sc.nextInt();
        }

        if (sum == X) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

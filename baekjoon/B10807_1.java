package baekjoon;

import java.util.Scanner;

public class B10807_1 {
    private static int[] input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        int X = sc.nextInt();

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (input[i] == X)
                cnt++;
        }

        System.out.println(cnt);
    }
}

package baekjoon;

import java.util.Scanner;

public class B5597_1 {
    private static boolean[] check = new boolean[31];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 28; i++) {
            check[sc.nextInt()] = true;
        }

        for (int i = 1; i <= 30; i++) {
            if (check[i] == false)
                System.out.println(i);
        }
    }
}

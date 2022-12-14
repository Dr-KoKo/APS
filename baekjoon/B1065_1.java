package baekjoon;

import java.util.Scanner;

public class B1065_1 {
    private static int X, cnt;

    public static void main(String[] args) {
        input();
        count();
        print();
    }

    private static void print() {
        System.out.println(cnt);
    }

    private static void count() {
        for (int i = 1; i <= X; i++) {
            if (seq(String.valueOf(i))) {
                cnt++;
            }
        }
    }

    private static boolean seq(String N) {
        switch (N.length()) {
            case 1:
            case 2:
                return true;
            case 3:
                int d1 = N.charAt(0) - N.charAt(1);
                int d2 = N.charAt(1) - N.charAt(2);
                if (d1 == d2) {
                    return true;
                }
            default:
                return false;
        }
    }

    private static void input() {
        Scanner input = new Scanner(System.in);

        X = input.nextInt();
        cnt = 0;
    }
}
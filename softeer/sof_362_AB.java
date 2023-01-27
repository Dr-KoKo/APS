package softeer;

import java.util.Scanner;

public class sof_362_AB {
    private static int A, B;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            sb.append("Case #" + t + ": ");
            logic(sc);
        }
        print();
    }

    private static void logic(Scanner sc) {
        input(sc);
        cal();

    }


    private static void print() {
        System.out.println(sb);
    }

    private static void cal() {
        sb.append(A + B).append('\n');
    }

    private static void input(Scanner sc) {
        A = sc.nextInt();
        B = sc.nextInt();
    }
}

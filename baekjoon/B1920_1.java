package baekjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B1920_1 {
    private static int N, M;
    private static Set<Integer> nSet;

    private static StringBuilder sb;


    public static void main(String[] args) {
        input();
        print();
    }

    private static void print() {
        System.out.println(sb);
    }

    private static void cal(Scanner input) {
        M = input.nextInt();
        for (int i = 0; i < M; i++) {
            sb.append(nSet.contains(input.nextInt()) ? 1 : 0).append('\n');
        }
    }

    private static void input() {
        Scanner input = new Scanner(System.in);
        sb = new StringBuilder();

        N = input.nextInt();
        nSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            nSet.add(input.nextInt());
        }

        cal(input);
    }
}

package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B1015_2 {
    private static int N;
    private static int[] ans;
    private static Elem[] elems;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        generateAns();
        print();
    }

    private static void print() {
        System.out.println(sb);
    }

    private static void generateAns() {
        Arrays.sort(elems);

        for (int i = 0; i < N; i++) {
            ans[elems[i].idx] = i;
        }

        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append(' ');
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        ans = new int[N];
        elems = new Elem[N];
        for (int i = 0; i < N; i++) {
            elems[i] = new Elem(i, sc.nextInt());
        }
    }

    private static class Elem implements Comparable<Elem> {
        private int idx;
        private int num;

        public Elem(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }

        @Override
        public int compareTo(Elem o) {
            return this.num - o.num;
        }
    }
}

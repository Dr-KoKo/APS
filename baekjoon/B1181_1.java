package baekjoon;

import java.util.*;

public class B1181_1 {
    private static int N;
    private static String[] strs;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        sort();
        print();
    }

    private static void print() {
        for (String str : strs) {
            sb.append(str).append('\n');
        }
        System.out.println(sb);
    }

    private static void sort() {
        strs = Arrays.stream(strs).sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        }).distinct().toArray(String[]::new);
    }

    private static void input() {
        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        strs = new String[N];
        for (int i = 0; i < N; i++) {
            strs[i] = input.next();
        }
    }
}

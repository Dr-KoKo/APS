package baekjoon;

import java.util.*;
import java.util.stream.Collectors;

public class B1764_1 {
    private static int N, M;
    private static Set<String> hearNot, seenNot;
    private static List<String> ans;

    private static StringBuilder sb;

    public static void main(String[] args) {
        input();
        cal();
        print();
    }

    private static void print() {
        System.out.println(sb);
    }

    private static void cal() {
        ans = hearNot.stream().filter(x -> seenNot.contains(x)).sorted().collect(Collectors.toList());
        sb.append(ans.size()).append('\n');
        for (String str : ans) {
            sb.append(str).append('\n');
        }
    }

    private static void input() {
        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        M = input.nextInt();

        hearNot = new HashSet<>();
        seenNot = new HashSet<>();

        sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            hearNot.add(input.next());
        }
        for (int i = 1; i <= M; i++) {
            seenNot.add(input.next());
        }

        input.close();
    }
}

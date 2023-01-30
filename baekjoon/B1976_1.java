package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B1976_1 {
    private static int N, M;
    private static int[] p, rank;
    private static List<Integer> path;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        p = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            p[i] = i;
        }

        rank = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int road = sc.nextInt();

                if (road == 1) {
                    union(i, j);
                }
            }
        }

        path = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int node = sc.nextInt();

            path.add(node);
        }

        if (check(path)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean check(List<Integer> path) {
        int parent = getParent(path.get(0));

        return path.stream().filter(x -> getParent(x) == parent).count() == M;
    }

    private static void union(int node1, int node2) {
        int pA = getParent(node1);
        int pB = getParent(node2);

        if (rank[pA] >= rank[pB]) {
            p[pB] = pA;
            if (rank[pA] == rank[pB]) {
                rank[pA]++;
            }
        } else {
            p[pA] = pB;
        }
    }

    private static int getParent(int node) {
        if (p[node] == node)
            return node;
        return p[node] = getParent(p[node]);
    }
}

package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B1976_2 {
    private static int N, M;
    private static int[] p, rank;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        p = new int[N + 1];
        for (int n = 0; n <= N; n++) {
            p[n] = n;
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

        ArrayList<Integer> path = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            path.add(sc.nextInt());
        }
        if (check(path))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static boolean check(ArrayList<Integer> path) {
        int parent = getParent(path.get(0));
        return path.stream().filter(x -> getParent(x) == parent).count() == M;
    }


    private static void union(int node1, int node2) {
        int p1 = getParent(node1);
        int p2 = getParent(node2);

        if (rank[p1] >= rank[p2]) {
            p[p2] = p1;
            if (rank[p1] == rank[p2])
                rank[p1]++;
        } else {
            p[p1] = p2;
        }
    }

    private static int getParent(int node) {
        if (p[node] == node)
            return node;
        return p[node] = getParent(p[node]);
    }
}

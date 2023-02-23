package baekjoon;

import java.util.Scanner;

public class B1717_2 {
    private static int N, M;
    private static int[] p, rank;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt();
        M = sc.nextInt();

        p = new int[N + 1];
        for (int n = 0; n <= N; n++) {
            p[n] = n;
        }
        rank = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int op = sc.nextInt();

            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            switch (op) {
                case 0:
                    union(node1, node2);
                    break;

                case 1:
                    if (getParent(node1) == getParent(node2))
                        sb.append("YES").append('\n');
                    else
                        sb.append("NO").append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }

    private static void union(int node1, int node2) {
        int p1 = getParent(node1);
        int p2 = getParent(node2);

        if (rank[p1] >= rank[p2]) {
            p[p2] = p1;
            if (rank[p1] == rank[p2]) {
                rank[p1]++;
            }
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

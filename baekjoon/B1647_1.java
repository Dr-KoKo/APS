package baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B1647_1 {
    private static int N, M;
    private static int ans;
    private static int[] p, rank;
    private static boolean[] check;
    private static Edge[] edges;

    public static void main(String[] args) {
        input();

        cal();

        print();
    }

    private static void print() {
        System.out.println(ans);
    }

    private static void cal() {
        ans = 0;
        int num = 0;
        for (int i = 0; i < edges.length; i++) {
            Edge curr = edges[i];

            if (!findParent(curr.from, curr.to)) {
                check[i] = true;
                num++;
                ans += edges[i].cost;

                union(curr.from, curr.to);
            }

            if (num == N - 1) {
                break;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < check.length; i++) {
            if (check[i]) {
                max = Math.max(max, edges[i].cost);
            }
        }

        ans -= max;
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        p = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            p[i] = i;
        }
        rank = new int[N + 1];

        edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            edges[i] = new Edge(from, to, cost);
        }

        check = new boolean[M];

        sc.close();

        Arrays.sort(edges, Comparator.comparingInt(o -> o.cost));
    }

    private static void union(int from, int to) {
        int parentA = getParent(from);
        int parentB = getParent(to);

        if (rank[parentA] >= rank[parentB]) {
            p[parentB] = parentA;
            if (rank[parentA] == rank[parentB]) {
                rank[parentA]++;
            }
        } else {
            p[parentA] = parentB;
        }
    }

    private static boolean findParent(int from, int to) {
        return getParent(from) == getParent(to);
    }

    private static int getParent(int node) {
        if (p[node] == node)
            return node;
        return p[node] = getParent(p[node]);
    }

    private static class Edge {
        int from, to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}

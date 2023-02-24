package baekjoon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B1922_1 {
    private static int N, M;
    private static int[] p, rank;
    private static PriorityQueue<Edge> pq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        p = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            p[i] = i;
        }

        rank = new int[N + 1];

        pq = new PriorityQueue<>((Comparator.comparingInt(o -> o.cost)));
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            pq.add(new Edge(from, to, cost));
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if(!findParent(curr.from, curr.to)){
                sum += curr.cost;
                union(curr.from, curr.to);
            }
        }

        System.out.println(sum);
    }

    private static boolean findParent(int node1, int node2) {
        return getParent(node1) == getParent(node2);
    }

    private static void union(int node1, int node2) {
        int parentA = getParent(node1);
        int parentB = getParent(node2);

        if (rank[parentA] >= rank[parentB]) {
            p[parentB] = parentA;

            if (rank[parentA] == rank[parentB]) {
                rank[parentA]++;
            }
        } else {
            p[parentA] = parentB;
        }
    }

    private static int getParent(int node) {
        if (p[node] == node)
            return node;
        return p[node] = getParent(p[node]);
    }

    private static class Edge {
        private int from, to;
        private int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}

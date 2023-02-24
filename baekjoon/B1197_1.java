package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B1197_1 {
    private static int V, E;
    private static int[] p, rank;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();

        p = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            p[i] = i;
        }
        rank = new int[V + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            pq.add(new Edge(from, to, cost));
        }

        int ans = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (getParent(curr.from) != getParent(curr.to)) {
                ans += curr.cost;
                union(curr.from, curr.to);
            }
        }

        System.out.println(ans);
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
        if (p[node] == node) return node;
        return p[node] = getParent(p[node]);
    }

    private static class Edge implements Comparable<Edge> {
        int from, to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }


        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}

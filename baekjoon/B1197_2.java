package baekjoon;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B1197_2 {
    private static int V, E;
    private static LinkedList<Edge>[] edgeList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();

        edgeList = new LinkedList[V + 1];
        for (int i = 0; i <= V; i++) {
            edgeList[i] = new LinkedList<>();
        }

        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            edgeList[from].add(new Edge(to, cost));
            edgeList[to].add(new Edge(from, cost));
        }

        boolean[] visited = new boolean[V + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

        pq.add(new Edge(1, 0));

        int ans = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if(visited[curr.vertex]) continue;

            ans += curr.cost;
            visited[curr.vertex] = true;

            for (Edge edge : edgeList[curr.vertex]) {
                if (visited[edge.vertex]) continue;

                pq.add(edge);
            }
        }

        System.out.println(ans);
    }

    private static class Edge implements Comparable<Edge> {
        int vertex;
        int cost;

        public Edge(int vertext, int cost) {
            this.vertex = vertext;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}

package programmers;

import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class P42861_prim {
    private List<Edge>[] edgeList;
    private boolean[] visited;

    public int solution(int n, int[][] costs) {
        edgeList = new LinkedList[n + 1];
        for (int i = 0; i <= n; i++) {
            edgeList[i] = new LinkedList<Edge>();
        }

        for (int[] edge : costs) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            edgeList[from].add(new Edge(from, to, cost));
            edgeList[to].add(new Edge(to, from, cost));
        }

        visited = new boolean[n + 1];

        int ans = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(1, 1, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (visited[curr.to]) continue;

            visited[curr.to] = true;
            ans += curr.cost;

            for (Edge edge : edgeList[curr.to]) {
                if (!visited[edge.to]) {
                    pq.add(new Edge(edge.from, edge.to, edge.cost));
                }
            }
        }

        return ans;
    }

    private class Edge implements Comparable<Edge> {
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
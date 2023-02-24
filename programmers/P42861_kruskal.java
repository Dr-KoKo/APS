package programmers;

import java.util.PriorityQueue;
import java.util.Comparator;

class P42861_kruskal {
    private int[] p, rank;
    private PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

    public int solution(int n, int[][] costs) {
        p = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            p[i] = i;
        }
        rank = new int[n + 1];

        for (int[] costArr : costs) {
            int from = costArr[0];
            int to = costArr[1];
            int cost = costArr[2];

            pq.add(new Edge(from, to, cost));
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (getParent(curr.from) != getParent(curr.to)) {
                answer += curr.cost;
                union(curr.from, curr.to);
            }
        }

        return answer;
    }

    private int getParent(int node) {
        if (p[node] == node) return node;
        return p[node] = getParent(p[node]);
    }

    private void union(int node1, int node2) {
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

    private class Edge {
        int from, to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
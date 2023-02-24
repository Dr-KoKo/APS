package baekjoon;

import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;

public class B1922_2 {
    private static int N, M;
    private static PriorityQueue<Edge> pq = new PriorityQueue<Edge>(Comparator.comparingInt(o->o.cost));
    private static int[] p, rank;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            pq.add(new Edge(from, to, cost));
        }

        p = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            p[i] = i;
        }
        rank = new int[N + 1];

        int sum = 0;
        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(getParent(curr.from)!=getParent(curr.to)){
                sum += curr.cost;
                union(curr.from, curr.to);
            }
        }

        System.out.println(sum);
    }

    private static void union(int node1, int node2) {
        int p1 = getParent(node1);
        int p2 = getParent(node2);

        if(rank[p1]>=rank[p2]){
            p[p2] = p1;
            if(rank[p1]==rank[p2]){
                rank[p1]++;
            }
        } else {
            p[p1] = p2;
        }
    }

    private static int getParent(int node){
        if(p[node]==node) return node;
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

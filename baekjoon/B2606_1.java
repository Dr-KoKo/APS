package baekjoon;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class B2606_1 {
    private static LinkedList[] edge;
    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        edge = new LinkedList[N + 1];
        for (int i = 1; i <= N; i++) {
            edge[i] = new LinkedList<Integer>();
        }

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            edge[from].add(to);
            edge[to].add(from);
        }

        int ans = DFS();

        System.out.println(ans);
    }

    private static int DFS() {
        boolean[] visited = new boolean[N+1];
        int ans = 0;

        DFSUtil(1, visited);

        for (int i = 1; i <= N; i++) {
            if (i == 1)
                continue;

            if (visited[i])
                ans++;
        }

        return ans;
    }

    private static void DFSUtil(int node, boolean[] visited) {

        visited[node] = true;

        Iterator<Integer> iterator = edge[node].iterator();

        while (iterator.hasNext()) {
            int nextNode = iterator.next();

            if (!visited[nextNode]) {
                DFSUtil(nextNode, visited);
            }
        }
    }
}

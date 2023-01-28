package baekjoon;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class B2606_2 {
    private static List<Integer>[] edge;
    private static int N;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        N = input.nextInt(); // N : 총 노드의 수

        edge = new LinkedList[N + 1]; // edge : 간선의 정보를 저장할 List. LinkedList[]배열로 구현.
        for (int i = 0; i <= N; i++) {
            edge[i] = new LinkedList<>();
        }

        int E = input.nextInt(); // E : 총 입력의 수
        for (int e = 0; e < E; e++) {
            int first = input.nextInt();
            int second = input.nextInt();

            edge[first].add(second);
            edge[second].add(first);
        }

//        System.out.println(DFS(1));
        System.out.println(BFS(1));

        input.close();
    }

    /**
     * @param n : 시작노드
     * @return (시작노드를 제외한) 감염된 총 컴퓨터의 수
     */
    private static int BFS(int n) {
        boolean[] visited = new boolean[N + 1];
        int ans = 0;

        LinkedList<Integer> queue = new LinkedList<>();

        visited[n] = true;
        queue.add(n);

        while (queue.size() != 0) {
            Integer node = queue.poll();

            for (Integer nextNode : edge[node]) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    ans++;

                    queue.add(nextNode);
                }
            }
        }

        return ans;
    }

    /**
     * @param n : 시작노드
     * @return (시작노드를 제외한) 감염된 총 컴퓨터의 수
     */
    private static int DFS(int n) {
        boolean[] visited = new boolean[N + 1]; // 방문체크를 위한 visited배열 생성

        DFSUtil(n, visited); // DFS 실행

        int ans = 0;

        for (int i = 0; i < visited.length; i++) {
            if (i == n)
                continue;

            if (visited[i])
                ++ans;
        }

        return ans;
    }

    /**
     * @param i       : 방문 노드
     * @param visited : 방문체크를 위한 visited배열
     */
    private static void DFSUtil(int i, boolean[] visited) {
        visited[i] = true;

        for (Integer n : edge[i]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
}

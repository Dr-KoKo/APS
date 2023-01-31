package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717_1 {
    private static int n, m;
    private static int[] p, rank;

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        rank = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int op = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            switch (op) {
                case 0:
                    union(first, second);
                    break;
                case 1:
                    if (findParent(first, second)) {
                        sb.append("YES").append('\n');
                    } else {
                        sb.append("NO").append('\n');
                    }
            }
        }

        System.out.println(sb);
    }

    private static boolean findParent(int node1, int node2) {
        return getParent(node1) == getParent(node2);
    }

    private static void union(int node1, int node2) {
        int a = getParent(node1);
        int b = getParent(node2);

        if (rank[a] >= rank[b]) {
            p[b] = a;
            if (rank[a] == rank[b])
                rank[a]++;
        } else {
            p[a] = b;
        }
    }

    private static int getParent(int node) {
        if (p[node] == node)
            return node;
        return p[node] = getParent(p[node]);
    }
}

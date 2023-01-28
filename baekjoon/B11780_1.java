package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B11780_1 {
    private static final int MAX = 10000001;
    private static int n, m;
    private static int[][] dist;

    private static LinkedList<Integer>[][] path;

    public static void main(String[] args) throws IOException {
        input();

        cal();

        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == MAX) {
                    sb.append(0).append(' ');
                    continue;
                }
                sb.append(dist[i][j]).append(' ');
            }
            sb.append('\n');
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(path[i][j].size()).append(' ');
                for (Integer node : path[i][j]) {
                    sb.append(node).append(' ');
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }

    private static void cal() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] == MAX || dist[k][j] == MAX) continue;

                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];

                        path[i][j].clear();

                        for (int l = 0; l < path[i][k].size(); l++) {
                            path[i][j].add(path[i][k].get(l));
                        }
                        for (int l = 1; l < path[k][j].size(); l++) {
                            path[i][j].add(path[k][j].get(l));
                        }
                    }
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n + 1][n + 1];
        path = new LinkedList[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dist[i][j] = i == j ? 0 : MAX;
                path[i][j] = new LinkedList<>();
            }
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (dist[from][to] > cost) {
                dist[from][to] = cost;

                path[from][to].clear();
                path[from][to].add(from);
                path[from][to].add(to);
            }
        }
    }
}

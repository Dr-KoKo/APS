package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B15649_1 {

    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        M = input.nextInt();

        perm();

        input.close();

    }

    private static void perm() {

        boolean[] visited = new boolean[N + 1];
        int[] result = new int[M];
        Arrays.fill(result, -1);

        permUtil(0, 0, visited, result);

        System.out.println(sb);

    }

    private static void permUtil(int idx, int sidx, boolean[] visited, int[] result) {

        if (sidx == M) {

            for (int i : result) {
                if (i != -1)
                    sb.append(i).append(" ");
            }

            sb.append("\n");

            return;
        }

        if (idx == N)
            return;

        for (int i = 1; i <= N; i++) {

            if (visited[i])
                continue;

            result[sidx] = i;

            visited[i] = true;
            permUtil(idx + 1, sidx + 1, visited, result);

            visited[i] = false;

        }

    }

}

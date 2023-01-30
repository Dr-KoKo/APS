package baekjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class B2178_1 {
    private static int row, col;
    private static int ans;
    private static int[][] map;
    private static boolean[][] visited;

    private static final int[][] drc = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        row = sc.nextInt();
        col = sc.nextInt();

        map = new int[row + 2][col + 2];
        for (int i = 1; i <= row; i++) {
            char[] input = sc.next().toCharArray();
            for (int j = 1; j <= col; j++) {
                map[i][j] = input[j - 1] - '0';
            }
        }

        BFS();

        System.out.println(ans);
    }

    private static void BFS() {
        visited = new boolean[row + 2][col + 2];
        LinkedList<Pos> queue = new LinkedList<>();

        visited[1][1] = true;
        queue.add(new Pos(1, 1));

        ans = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Pos curr = queue.poll();

                for (int[] ints : drc) {
                    int nextRow = curr.r + ints[1];
                    int nextCol = curr.c + ints[0];

                    if (nextRow == row && nextCol == col) {
                        ans++;
                        return;
                    }

                    if (map[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                        visited[nextRow][nextCol] = true;
                        queue.add(new Pos(nextRow, nextCol));
                    }
                }
            }

            ans++;
        }
    }

    private static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

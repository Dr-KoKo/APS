package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B11559_1 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] board = new char[12][6];

    static List<Point> bfs(int x, int y, char c) {
        List<Point> group = new ArrayList<>();
        List<Point> queue = new ArrayList<>();
        queue.add(new Point(x, y));
        group.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point p = queue.remove(0);
            x = p.x;
            y = p.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < 12 && 0 <= ny && ny < 6 && board[nx][ny] == c) {
                    Point np = new Point(nx, ny);
                    if (!group.contains(np)) {
                        queue.add(np);
                        group.add(np);
                    }
                }
            }
        }
        return group;
    }

    static void removeGroup(List<Point> group) {
        for (Point p : group) {
            board[p.x][p.y] = '.';
        }
    }

    static void collapseBoard() {
        for (int y = 0; y < 6; y++) {
            int writeIdx = 11;
            for (int x = 11; x >= 0; x--) {
                if (board[x][y] != '.') {
                    board[writeIdx][y] = board[x][y];
                    writeIdx--;
                }
            }
            for (int x = writeIdx; x >= 0; x--) {
                board[x][y] = '.';
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 12; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        int ret = 0;
        int clusters = 0;
        while (true) {
            clusters = 0;
            for (int x = 0; x < 12; x++) {
                for (int y = 0; y < 6; y++) {
                    if (board[x][y] != '.') {
                        List<Point> group = bfs(x, y, board[x][y]);
                        if (group.size() >= 4) {
                            removeGroup(group);
                            clusters++;
                        }
                    }
                }
            }
            if (clusters == 0) {
                break;
            }
            collapseBoard();
            ret++;
        }
        System.out.println(ret);
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Point p = (Point) obj;
            return p.x == x && p.y == y;
        }
    }
}
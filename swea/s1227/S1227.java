package s1227;

import java.util.Scanner;

public class S1227 {

	private static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	private static int[] ans = new int[11];
	private static int t;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {

			t = input.nextInt();
			input.nextLine();

			int[][] maze = new int[100 + 2][100 + 2];
			int[] start = new int[2];
			int[] end = new int[2];

			for (int j = 0; j < 102; j++) {
				maze[0][j] = 1;
				maze[101][j] = 1;
			}

			for (int i = 1; i <= 100; i++) {

				maze[i][0] = 1;
				maze[i][101] = 1;

				char[] inputLine = input.nextLine().toCharArray();

				for (int j = 1; j <= 100; j++) {

					int in = inputLine[j - 1] - '0';

					if (in == 2) {
						start[0] = i;
						start[1] = j;
					} else if (in == 3) {
						end[0] = i;
						end[1] = i;
					}

					maze[i][j] = in;

				}

			}

			DFS(maze, start);

		}

		for (int tc = 1; tc <= 10; tc++) {
			System.out.printf("#%d %d\n", tc, ans[tc]);
		}

		input.close();

	}

	private static void DFS(int[][] maze, int[] target) {
		int r = target[0];
		int c = target[1];

		maze[r][c] = 1;

		for (int i = 0; i < 4; i++) {
			int nr = r + drc[i][0];
			int nc = c + drc[i][1];

			switch (maze[nr][nc]) {
			case 0:
				DFS(maze, new int[] { nr, nc });
			case 1:
			case 2:
				continue;
			case 3:
				ans[t] = 1;
			}

		}
	}

}

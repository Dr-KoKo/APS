package s7733;

import java.util.Scanner;

public class S7733 {

	private static int N;
	private static int[][] mat;

	private static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = input.nextInt();

			mat = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					mat[i][j] = input.nextInt();

				}
			}

			int ans = check();

			System.out.printf("#%d %d\n", tc, ans);

		}

		input.close();

	}

	private static int check() {

		int ans = 0;

		for (int n = 1; n <= 100; n++) {

			boolean[][] visited = new boolean[N][N];
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (mat[i][j] > n && !visited[i][j]) {
						DFS(i, j, n, visited);
						++cnt;
					}

				}
			}

			ans = Math.max(ans, cnt);

		}

		return ans == 0 ? 1 : ans;

	}

	private static void DFS(int x, int y, int n, boolean[][] visited) {

		visited[x][y] = true;

		for (int d = 0; d < drc.length; d++) {

			int nr = x + drc[d][0];
			int nc = y + drc[d][1];

			if (inBound(nr, nc) && mat[nr][nc] > n && !visited[nr][nc]) {
				DFS(nr, nc, n, visited);
			}

		}

	}

	private static boolean inBound(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}

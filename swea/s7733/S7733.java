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
			// 1. 입력
			N = input.nextInt();

			mat = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					mat[i][j] = input.nextInt();

				}
			}
			// 2. 계산
			int ans = check();
			// 3. 출력
			System.out.printf("#%d %d\n", tc, ans);

		}

		input.close();

	}

	/**
	 * 모든 원소를 순회하면서 맛이 특정일보다 큰 경우 그 덩어리를 방문체크 및 카운트.
	 * @return ans : 계산 결과
	 */
	private static int check() {

		int ans = 1;

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

		return ans;

	}

	/**
	 * 방문체크
	 * @param x, y : 방문한 위치
	 * @param n : 방문일
	 * @param visited : 방문체크를 위한 배열
	 */
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

	/**
	 * @param nr, nc : 대상 좌표
	 * @return 범위 내면 true, 밖이면 false
	 */
	private static boolean inBound(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}

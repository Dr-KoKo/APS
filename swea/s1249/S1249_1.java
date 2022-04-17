package swea.s1249;

import java.util.Arrays;
import java.util.Scanner;

public class S1249_1 {

	static enum drc {
		Right(0, 1), Down(1, 0), Left(0, -1), Top(-1, 0);

		int r, c;

		private drc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int N;
	static int ans;
	static final int INF = Integer.MAX_VALUE;
	static int[][] map, visited;
	static Pos start, end;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 1. 입력
			N = input.nextInt();

			map = new int[N][N];

			for (int i = 0; i < N; i++) {

				String line = input.next();

				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j) - '0';
				}

			}

			// 2. 계산
			start = new Pos(0, 0);
			end = new Pos(N - 1, N - 1);
			DFS();

			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}

		System.out.print(sb);

	}

	private static void DFS() {
		// 도구 준비
		ans = 0;
		for (int i = 0; i < N; i++) {
			ans += map[0][i];
		}
		for (int i = 0; i < N; i++) {
			ans += map[i][N - 1];
		}

		visited = new int[N][N];
		for (int[] is : visited) {
			Arrays.fill(is, INF);
		}
		visited[0][0] = 0;

		// 결행
		DFSUtil(start);

	}

	private static void DFSUtil(Pos pos) {

		if (pos.r == end.r && pos.c == end.c) {
			ans = Math.min(ans, visited[end.r][end.c]);
			return;
		}

		if (visited[pos.r][pos.c] > ans)
			return;

		for (drc d : drc.values()) {

			int nr = pos.r + d.r;
			int nc = pos.c + d.c;

			if (!inBound(nr, nc))
				continue;

			if (visited[nr][nc] > visited[pos.r][pos.c] + map[nr][nc]) {
				visited[nr][nc] = visited[pos.r][pos.c] + map[nr][nc];
				DFSUtil(new Pos(nr, nc));
			}

		}

	}

	private static boolean inBound(int nx, int ny) {
		return nx >= 0 && nx < N && ny >= 0 && ny < N;
	}

}

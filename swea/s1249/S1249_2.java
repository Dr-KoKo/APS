package s1249;

import java.util.PriorityQueue;
import java.util.Scanner;

public class S1249_2 {

	enum drc {
		Right(0, 1), Down(1, 0), Left(0, -1), Top(-1, 0);

		int dr, dc;

		private drc(int dr, int dc) {
			this.dr = dr;
			this.dc = dc;
		}
	}

	static class Pos implements Comparable<Pos> {
		int r, c;
		int cost;

		public Pos(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Pos o) {
			return this.cost - o.cost;
		}
	}

	static int N;
	static final int INF = Integer.MAX_VALUE;
	static int[][] map, dist;
	static int ans;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = input.nextInt();

			map = new int[N][N];
			dist = new int[N][N];

			for (int i = 0; i < N; i++) {

				String str = input.next();

				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
					dist[i][j] = INF;
				}

			}

			dijkstra(new Pos(0, 0, map[0][0]), new Pos(N - 1, N - 1, map[N - 1][N - 1]));

			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}

		System.out.print(sb);

	}

	private static void dijkstra(Pos start, Pos end) {
		// 도구 준비
		PriorityQueue<Pos> pq = new PriorityQueue<>();

		boolean[][] visited = new boolean[N][N];

		dist[start.r][start.c] = 0;

		// dijkstra
		pq.add(start);
		while (!pq.isEmpty()) {

			Pos currPos = pq.poll();

			if (visited[currPos.r][currPos.c])
				continue;
			visited[currPos.r][currPos.c] = true;

			if (currPos.r == end.r && currPos.c == end.c) {
				ans = dist[currPos.r][currPos.c];
			}

			for (drc d : drc.values()) {
				int nr = currPos.r + d.dr;
				int nc = currPos.c + d.dc;

				if (!inBound(nr, nc) || visited[nr][nc])
					continue;

				if (dist[nr][nc] > currPos.cost + map[nr][nc]) {
					dist[nr][nc] = currPos.cost + map[nr][nc];
				}

				pq.add(new Pos(nr, nc, dist[nr][nc]));

			}

		}

	}

	private static boolean inBound(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}

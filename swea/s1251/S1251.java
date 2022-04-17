package s1251;

import java.util.Arrays;
import java.util.Scanner;

public class S1251 {

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static int N;
	static double C;
	static int[] p;
	static long[] dist;
	static boolean[] visited;
	static Pos[] islands;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 1.입력
			N = input.nextInt();
			input.nextLine();

			String[] xs = input.nextLine().split(" ");
			String[] ys = input.nextLine().split(" ");

			islands = new Pos[N];

			for (int i = 0; i < N; i++) {
				islands[i] = new Pos(Integer.parseInt(xs[i]), Integer.parseInt(ys[i]));
			}

			C = input.nextDouble();

			// 2.계산
			// 2-1.도구준비
			p = new int[N];

			dist = new long[N];
			Arrays.fill(dist, Long.MAX_VALUE);

			visited = new boolean[N];
			// 2-2. 계산 : 시작점은 islands[0]
			p[1] = -1;
			dist[1] = 0L;

			long min = 0L;
			double ans = 0;
			int idx = 0;

			for (int i = 0; i < N; i++) {

				min = Long.MAX_VALUE;
				idx = -1;

				for (int j = 0; j < N; j++) {
					if (!visited[j] && dist[j] < min) {
						min = dist[j];
						idx = j;
					}
				}

				visited[idx] = true;

				for (int j = 0; j < N; j++) {
					if (!visited[j] && dist[j] > calDist(idx, j)) {
						p[j] = idx;
						dist[j] = calDist(idx, j);
					}
				}

			}

			for (int i = 0; i < N; i++) {
				ans += dist[i];
			}

			ans *= C;

			sb.append("#").append(tc).append(" ").append(Math.round(ans)).append("\n");

		}

		System.out.print(sb);

		input.close();

	}

	private static long calDist(int start, int end) {
		long start_x = islands[start].x;
		long start_y = islands[start].y;
		long end_x = islands[end].x;
		long end_y = islands[end].y;

		return (start_x - end_x) * (start_x - end_x) + (start_y - end_y) * (start_y - end_y);
	}

}

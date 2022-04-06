package s1247;

import java.util.Scanner;

public class S1247_1 {

	static class Pos {

		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	private static Pos home, work;
	private static Pos[] data;
	private static int N;
	private static int ans;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = input.nextInt();

			home = new Pos(input.nextInt(), input.nextInt());
			work = new Pos(input.nextInt(), input.nextInt());
			data = new Pos[N];

			for (int i = 0; i < N; i++) {

				data[i] = new Pos(input.nextInt(), input.nextInt());

			}

			perm();

			System.out.printf("#%d %d\n", tc, ans);

		}

		input.close();

	}

	private static void perm() {

		ans = Integer.MAX_VALUE;

		boolean[] visited = new boolean[N];

		permUtil(0, visited, new Pos[N]);

	}

	private static void permUtil(int idx, boolean[] visited, Pos[] result) {

		if (idx == N) {

			calDist(result);

		}

		for (int i = 0; i < N; i++) {

			if (visited[i])
				continue;

			result[idx] = data[i];
			visited[i] = true;
			permUtil(idx + 1, visited, result);

			visited[i] = false;

			// 삽입, 삭제가 용이한 자료구조가 유리할 것 : LinkedList??
			// dist를 인자로 넘겨주면 result배열 및 visit배열 없이 만들 수 있을지도?
			// deque를 쓰면 result배열 및 visit배열 없이 만들 수 있을지도?
		}

	}

	private static void calDist(Pos[] result) {

		int ret = 0;

		ret += Math.abs(result[0].r - home.r) + Math.abs(result[0].c - home.c);

		for (int i = 1; i < N; i++) {

			ret += Math.abs(result[i].r - result[i - 1].r) + Math.abs(result[i].c - result[i - 1].c);

		}

		ret += Math.abs(result[N - 1].r - work.r) + Math.abs(result[N - 1].c - work.c);

		ans = Math.min(ans, ret);
	}

}

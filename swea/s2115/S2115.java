package s2115;

import java.util.Scanner;

public class S2115 {

	static class Pos {
		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M, C;
	static int ans;
	static int temp;
	static int[][] honey;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = input.nextInt();
			M = input.nextInt();
			C = input.nextInt();

			honey = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					honey[i][j] = input.nextInt();

				}
			}

			cal();

			sb.append("#").append(tc);
			sb.append(" ").append(ans);
			sb.append("\n");
		}

		System.out.print(sb);

		input.close();

	}

	private static void cal() {

		ans = 0;

		Pos p1;
		Pos p2;

		for (int i1 = 0; i1 < N; i1++) {
			for (int j1 = 0; j1 < N - M + 1; j1++) {

				temp = 0;

				p1 = new Pos(i1, j1);
				calUtil(p1, 0, 0, 0);

				int temp1 = temp;

				for (int i2 = 0; i2 < N; i2++) {
					for (int j2 = 0; j2 < N - M + 1; j2++) {

						if (i1 == i2 && Math.abs(j2 - j1) < M)
							continue;

						temp = 0;

						p2 = new Pos(i2, j2);
						calUtil(p2, 0, 0, 0);

						int temp2 = temp;

						ans = Math.max(ans, temp1 + temp2);

					}
				}

			}
		}

	}

	private static void calUtil(Pos p, int idx, int sum, int sumSquare) {

		if (sum > C)
			return;

		if (idx == M) {
			temp = Math.max(temp, sumSquare);
			return;
		}

		calUtil(p, idx + 1, sum, sumSquare);

		calUtil(p, idx + 1, sum + honey[p.r][p.c + idx], sumSquare + honey[p.r][p.c + idx] * honey[p.r][p.c + idx]);

	}

}

package b1012;

import java.util.Scanner;

public class B1012 {

	private static int[][] drc = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	private static int[][] map;
	private static int M, N;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			M = input.nextInt();
			N = input.nextInt();
			map = new int[M][N];

			int K = input.nextInt();
			for (int k = 0; k < K; k++) {
				map[input.nextInt()][input.nextInt()] = 1;
			}

			int ans = 0;
			for (int m = 0; m < M; m++) {
				for (int n = 0; n < N; n++) {
					if (map[m][n] == 1) {
						assign(m, n);
						ans++;
					}
				}
			}

			System.out.println(ans);

		}

		input.close();

	}

	private static void assign(int x, int y) {
		for (int i = 0; i < drc.length; i++) {
			int r = x + drc[i][0];
			int c = y + drc[i][1];

			if (!inBound(r, c))
				continue;
			else {
				int target = map[r][c];
				switch (target) {
				case 0:
					continue;
				case 1:
					map[r][c] = 0;
					assign(r, c);
					break;
				}
			}
		}
	}

	private static boolean inBound(int x, int y) {
		return 0 <= x && x < M && 0 <= y && y < N;
	}

}

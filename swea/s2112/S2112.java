package s2112;

import java.util.Scanner;

public class S2112 {

	static int[][] property;
	static int D, W, K;
	static int ans;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			D = input.nextInt();
			W = input.nextInt();
			K = input.nextInt();

			property = new int[D][W];

			for (int d = 0; d < D; d++) {
				for (int w = 0; w < W; w++) {

					property[d][w] = input.nextInt();

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

		ans = Integer.MAX_VALUE;

		int[] sel = new int[D];

		calUtil(0, 0, sel);

	}

	private static void calUtil(int idx, int cnt, int[] sel) {

		if (idx == D) {

			if (check(sel)) {

				ans = Math.min(ans, cnt);

			}

			return;
		}

		sel[idx] = -1;
		calUtil(idx + 1, cnt, sel);

		if (cnt + 1 < ans) {

			sel[idx] = 1;
			calUtil(idx + 1, cnt + 1, sel);

			sel[idx] = 0;
			calUtil(idx + 1, cnt + 1, sel);

		}

	}

	private static boolean check(int[] sel) {

		for (int w = 0; w < W; w++) {

			int t = 0;
			int cnt = 0;

			boolean isFlag = false;

			for (int d = 0; d < D; d++) {

				if (sel[d] == t)
					++cnt;
				else if (sel[d] == 1 - t) {
					cnt = 1;
					t = 1 - t;
				} else if (sel[d] == -1) {
					if (property[d][w] == t)
						++cnt;
					else {
						cnt = 1;
						t = 1 - t;
					}
				}

				if (cnt == K)
					isFlag = true;

			}

			if (!isFlag)
				return false;

		}

		return true;

	}
}

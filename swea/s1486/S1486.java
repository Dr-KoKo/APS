package s1486;

import java.util.Scanner;

public class S1486 {

	static int[] heights;
	static int N, B;
	static int ans;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = input.nextInt();
			B = input.nextInt();

			heights = new int[N];

			for (int i = 0; i < N; i++) {

				heights[i] = input.nextInt();

			}

			process();

			sb.append("#").append(tc);
			sb.append(" ").append(ans).append("\n");

		}

		System.out.print(sb);

		input.close();

	}

	private static void process() {

		ans = Integer.MAX_VALUE;

		boolean[] sel = new boolean[N];

		comb(0, sel, B);

	}

	private static void comb(int idx, boolean[] sel, int b) {

		if (b <= 0) {
			ans = Math.min(ans, -b);
			return;
		}
		
		if (idx == N) {
			return;
		}

		sel[idx] = true;
		comb(idx + 1, sel, b - heights[idx]);

		sel[idx] = false;
		comb(idx + 1, sel, b);

	}

}

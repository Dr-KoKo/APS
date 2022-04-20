package s1267;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class S1267_1 {

	static int N;
	static int[] sel;
	static int ans;
	static int[][] chart;
	static boolean[][] checked;
	static LinkedList<Integer> list;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = input.nextInt();

			chart = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					chart[i][j] = input.nextInt();
				}
			}

			comb();

			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}

		System.out.print(sb);

		input.close();

	}

	private static void comb() {
		// 도구
		ans = Integer.MAX_VALUE;
		sel = new int[N / 2];
		// 실행
		combUtil(0, 0);

	}

	private static void combUtil(int idx, int sidx) {

		if (sidx == N / 2) {
			check(sel);
			return;
		}
		if (idx == N) {
			return;
		}

		sel[sidx] = idx;
		combUtil(idx + 1, sidx + 1);
		combUtil(idx + 1, sidx);
	}

	private static void check(int[] sel) {

		List<Integer> unselList = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			boolean isFlag = true;
			for (int j = 0; j < N / 2; j++) {
				if (i == sel[j])
					isFlag = false;
			}
			if (isFlag)
				unselList.add(i);
		}

		int temp1 = 0;
		int temp2 = 0;

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N / 2; j++) {
				temp1 += chart[sel[i]][sel[j]];
			}
		}

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N / 2; j++) {
				temp2 += chart[unselList.get(i)][unselList.get(j)];
			}
		}

		ans = Math.min(ans, Math.abs(temp1 - temp2));

	}
}

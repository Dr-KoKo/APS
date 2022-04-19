package s13772;

import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);
	private static int N, P;
	private static int[][] happiness;
	private static int[][] drc = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	private static int[][] drcDig = { { -1, 1 }, { 1, 1 }, { 1, -1 }, { -1, -1 } };

	public static void main(String[] args) {
		int T = input.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = input.nextInt();
			P = input.nextInt();
			happiness = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					happiness[i][j] = input.nextInt();
				}
			}

			System.out.printf("#%d %d\n", tc, cal(P));
		}
	}

	private static int cal(int p) {
		int sumMax = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int sum;
				int sumDig;
				sum = sumDig = happiness[i][j];
				for (int k = 1; k <= p; k++) {
					for (int l = 0; l < 4; l++) {
						try {
							sum += happiness[i + k * drc[l][0]][j + k * drc[l][1]];
						} catch (IndexOutOfBoundsException e) {

						}
					}
					for (int l2 = 0; l2 < 4; l2++) {
						try {
							sumDig += happiness[i + k * drcDig[l2][0]][j + k * drcDig[l2][1]];
						} catch (IndexOutOfBoundsException e) {

						}
					}
				}
				sumMax = Math.max(sumMax, Math.max(sum, sumDig));
			}
		}
		return sumMax;
	}
}

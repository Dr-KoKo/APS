package swea.s4613;

import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int T = input.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = input.nextInt();
			int M = input.nextInt();
			input.nextLine();
			char[][] flag = new char[N][M];
			for (int i = 0; i < N; i++) {
				flag[i] = input.nextLine().toCharArray();
			}

			int sumMin = Integer.MAX_VALUE;

			for (int WBline = 1; WBline < N - 1; WBline++) {
				for (int BRline = WBline + 1; BRline < N; BRline++) {
					int sum = 0;

					for (int w = 0; w < WBline; w++) {
						for (int m = 0; m < M; m++) {
							if (flag[w][m] != 'W')
								sum++;
						}
					}
					for (int b = WBline; b < BRline; b++) {
						for (int m = 0; m < M; m++) {
							if (flag[b][m] != 'B')
								sum++;
						}
					}
					for (int r = BRline; r < N; r++) {
						for (int m = 0; m < M; m++) {
							if (flag[r][m] != 'R')
								sum++;
						}
					}
					sumMin = Math.min(sumMin, sum);
				}
			}

			System.out.printf("#%d %d\n", tc, sumMin);

		}
	}
}

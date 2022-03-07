package swea.s4615;

import java.util.Scanner;

public class Solution {
	static int N, M;
	static char[][] board;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = input.nextInt();
			M = input.nextInt();

			board = new char[N][N];
			board[N / 2][N / 2] = 'W';
			board[N / 2 - 1][N / 2] = 'B';
			board[N / 2][N / 2 - 1] = 'B';
			board[N / 2 - 1][N / 2 - 1] = 'W';

			for (int m = 0; m < M; m++) {
				check(input.nextInt() - 1, input.nextInt() - 1, input.nextInt());
			}

			int cntB = 0;
			int cntW = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 'B')
						cntB++;
					else if (board[i][j] == 'W')
						cntW++;
				}
			}

			System.out.printf("#%d %d %d\n", tc, cntB, cntW);

		}

		input.close();

	}

	private static void check(int y, int x, int color) {
		int[][] drc = { { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 } };
		int[] t = new int[drc.length];

		for (int d = 0; d < drc.length; d++) {
			for (int n = 1; n < N; n++) {
				if (!(inBound(x + n * drc[d][0], y + n * drc[d][1]))
						|| board[x + n * drc[d][0]][y + n * drc[d][1]] == '\u0000')
					break;
				if (board[x + n * drc[d][0]][y + n * drc[d][1]] == toChar(color)) {
					t[d] = n;
					break;
				}
			}
		}

		for (int d = 0; d < drc.length; d++) {
			for (int n = 0; n < t[d]; n++) {
				board[x + n * drc[d][0]][y + n * drc[d][1]] = toChar(color);
			}
		}
	}

	private static boolean inBound(int x, int y) {
		return !(x < 0 || x >= N || y < 0 || y >= N);
	}

	private static char toChar(int color) {
		if (color == 1)
			return 'B';
		else if (color == 2)
			return 'W';
		return 'X';
	}

}

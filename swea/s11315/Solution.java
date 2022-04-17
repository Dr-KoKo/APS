package swea.s11315;

import java.util.Scanner;

public class Solution {
	private static char[][] board;
	private static int[][] drc = { { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 } };
	private static int N;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = input.nextInt();
			board = new char[N][N];
			for (int i = 0; i < N; i++) {
				board[i] = input.next().toCharArray();
			}

			boolean isFive = false;
			outer: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 'o' && check(i, j)) {
						isFive = true;
						break outer;
					}
				}
			}

			StringBuilder sb = new StringBuilder();

			sb.append("#").append(tc).append(" ").append(isFive ? "YES" : "NO");

			System.out.println(sb);

		}

		input.close();

	}

	private static boolean check(int x, int y) {
		for (int d = 0; d < drc.length; d++) {
			boolean isFive = true;
			for (int n = 0; n < 5; n++) {
				if (!(inBound(x + n * drc[d][0], y + n * drc[d][1]))
						|| board[x + n * drc[d][0]][y + n * drc[d][1]] == '.') {
					isFive = false;
					break;
				}
			}
			if (isFive)
				return true;
		}
		return false;
	}

	private static boolean inBound(int x, int y) {
		return !(x < 0 || x >= N || y < 0 || y >= N);
	}
}

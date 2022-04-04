package b1018;

import java.util.Scanner;

public class B1018 {

	private static int N, M;
	private static int[][] board;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		N = input.nextInt();
		M = input.nextInt();
		input.nextLine();

		board = new int[N][M];

		for (int i = 0; i < N; i++) {

			char[] str = input.nextLine().toCharArray();

			for (int j = 0; j < M; j++) {

				if (str[j] == 'W')
					board[i][j] = 0;
				else if (str[j] == 'B')
					board[i][j] = 1;
				else
					System.out.println("error");

			}

		}

		int ans = Integer.MAX_VALUE;

		for (int i = 0; i <= N - 8; i++) {

			for (int j = 0; j <= M - 8; j++) {

				ans = Math.min(ans, countWork(board, i, j));

			}

		}

		System.out.println(ans);

		input.close();

	}

	private static int countWork(int[][] target, int x, int y) {

		int curr = 1;

		int retW = 0;
		int retB = 0;

		for (int i = 0; i < 8; i++) {

			for (int j = 0; j < 8; j++) {

				curr = 1 - curr;

				int nc = x + i;
				int nr = y + j;

				if (target[nc][nr] == curr)
					++retB;
				else if (target[nc][nr] == 1 - curr)
					++retW;
				else
					System.out.println("error2");

			}

			curr = 1 - curr;

		}

		return Math.min(retW, retB);

	}

}

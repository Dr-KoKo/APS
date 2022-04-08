package b15651;

import java.util.Scanner;

public class B15651 {

	static StringBuilder sb;

	static int N, M;
	static int[] board;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		N = input.nextInt();
		M = input.nextInt();

		board = new int[N];

		for (int i = 0; i < N; i++) {

			board[i] = 1 + i;

		}

		perm();

		input.close();

	}

	private static void perm() {

		sb = new StringBuilder();
		int[] result = new int[M];

		permUtil(1, 0, result);

		System.out.println(sb);

	}

	private static void permUtil(int idx, int sidx, int[] result) {

		if (sidx == M) {

			for (int i : result) {
				sb.append(i).append(" ");
			}

			sb.append("\n");

			return;

		}

		if (idx == N + 1)
			return;
		
		for (int i = 1; i <= N; i++) {
			
			result[sidx] = i;
			
			permUtil(idx + 1, sidx + 1, result);
			
		}


	}
}

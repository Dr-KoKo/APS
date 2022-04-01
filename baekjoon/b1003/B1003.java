package b1003;

import java.util.Scanner;

public class B1003 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int[][] memo = new int[41][2];
		memo[0][0] = 1;
		memo[0][1] = 0;
		memo[1][0] = 0;
		memo[1][1] = 1;
		for (int i = 2; i <= 40; i++) {
			if (memo[i][0] == 0 && memo[i][1] == 0) {
				memo[i][0] = memo[i - 1][0] + memo[i - 2][0];
				memo[i][1] = memo[i - 1][1] + memo[i - 2][1];
			}
		}

		int T = input.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = input.nextInt();

			System.out.printf("%d %d\n", memo[n][0], memo[n][1]);
		}

		input.close();

	}

}

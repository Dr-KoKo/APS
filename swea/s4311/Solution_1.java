package s4311;

import java.util.Scanner;

public class Solution_1 {

	static int N, O, M, W;
	static int[] nums, ops;
	static int ans;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = input.nextInt();
			O = input.nextInt();
			M = input.nextInt();

			nums = new int[N];
			for (int n = 0; n < N; n++) {
				nums[n] = input.nextInt();
			}

			ops = new int[O];
			for (int o = 0; o < O; o++) {
				ops[o] = input.nextInt();
			}

			W = input.nextInt();

			sb.append("#").append(tc).append(" ");

			if(initialTest(W)==-1) {
				ans = Integer.MAX_VALUE;
				for (int i = 0; i < nums.length; i++) {
					DFS(1, nums[i]);
				}
			} else {
				sb.append(initialTest(W)).append("\n");
			}


		}
	}

	private static int initialTest(int W) {
		int ret = 0;

		while (W / 10 != 0 || W % 10 != 0) {
			boolean isFlag = false;

			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == W % 10) {
					isFlag = true;
				}
			}

			if (!isFlag) {
				return -1;
			}

			ret++;
			W /= 10;
		}

		return ret;
	}

	private static void DFS(int m, int curr) {

		if (curr == W) {
			ans = Math.min(ans, m);
		}

	}
}

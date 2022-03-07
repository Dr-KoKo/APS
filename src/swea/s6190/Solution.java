package swea.s6190;

import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int T = input.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = input.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = input.nextInt();
			}

			int max = -1;
			for (int i = 1; i < N; i++) {
				for (int j = 0; j < i; j++) {
					int temp = arr[i] * arr[j];
					if (monotonic(temp))
						max = Math.max(max, temp);
				}
			}

			System.out.printf("#%d %d\n", tc, max);

		}

	}

	private static boolean monotonic(int num) {
//		String str = num +"";
//		String str = Integer.toString(num);
		String str = String.valueOf(num);
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) < str.charAt(i - 1))
				return false;
		}
		return true;
	}
}

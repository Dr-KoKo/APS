package s13636;

import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int T = input.nextInt();
		int[] ans = new int[T + 1];

		for (int tc = 1; tc <= T; tc++) {
			int N = input.nextInt();
			input.nextLine();

			char[] series = input.nextLine().toCharArray();

			ans[tc] = cal(series);
		}

		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d\n", tc, ans[tc]);
		}
		
	}

	public static int cal(char[] target) {
		int result = 0;
		int cnt = 0;

		for (char c : target) {
			if (c == '1')
				result = Math.max(result, ++cnt);
			else if (c == '0') {
				cnt = 0;
			}
		}
		return result;
	}
}

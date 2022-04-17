package swea.s13598;

import java.util.Scanner;

public class Solution_1 {

	static Scanner input = new Scanner(System.in);

	static int ans;

	public static void main(String[] args) {
		
		// 1.입력
		int N = input.nextInt();

		int[] arrI = input_arrI(N);
		
		// 2.계산
		ans = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {

			int cnt = 1;

			for (int j = i + 1; j < N; j++) {

				if (arrI[i] <= arrI[j])
					break;

				++cnt;

			}

			ans = cnt > ans ? cnt : ans;

		}

		// 3.출력
		System.out.println(ans);

	}

	private static int[] input_arrI(int n) {
		int[] ret = new int[n];

		for (int i = 0; i < n; i++) {
			ret[i] = input.nextInt();
		}

		return ret;
	}
}

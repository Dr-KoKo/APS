package s1959;

import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int[] arrI1 = new int[input.nextInt()];
			int[] arrI2 = new int[input.nextInt()];

			for (int i = 0; i < arrI1.length; i++) {
				arrI1[i] = input.nextInt();
			}
			for (int i = 0; i < arrI2.length; i++) {
				arrI2[i] = input.nextInt();
			}

			int arrMSum = (arrI1.length < arrI2.length) ? cal(arrI1, arrI2) : cal(arrI2, arrI1);

			System.out.printf("#%d %d\n", tc, arrMSum);

		}
	}

	public static int cal(int[] arr1, int[] arr2) { // arr1.length < arr2.length
		int arrMSum = Integer.MIN_VALUE; // 정답이 음수일 수도 있으므로, 음수로 초기화.
		for (int i = 0; i <= arr2.length - arr1.length; i++) {
			int sum = 0;
			for (int j = 0; j < arr1.length; j++) {
				sum += arr1[j] * arr2[j + i];
			}
			arrMSum = Math.max(arrMSum, sum);
		}
		return arrMSum;
	}
}

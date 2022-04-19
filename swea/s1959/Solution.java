package s1959;

import java.util.Scanner;

public class Solution {
	static Scanner input = new Scanner(System.in);
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = input.nextInt();
			int M = input.nextInt();
			
			int[] arrI1 = new int[N];
			int[] arrI2 = new int[M];

			for (int i = 0; i < N; i++) {
				arrI1[i] = input.nextInt();
			}
			for (int i = 0; i < M; i++) {
				arrI2[i] = input.nextInt();
			}

			int arrMSum = (N < M) ? cal(arrI1, arrI2) : cal(arrI2, arrI1);

			sb.append("#").append(tc).append(" ").append(arrMSum).append("\n");
			
		}
		
		System.out.print(sb);
		
	}

	public static int cal(int[] shortArr, int[] longArr) { // arr1.length < arr2.length
		int arrMSum = Integer.MIN_VALUE; // 정답이 음수일 수도 있으므로, 음수로 초기화.
		
		for (int i = 0; i <= longArr.length - shortArr.length; i++) {
			int temp = 0;
			
			for (int j = 0; j < shortArr.length; j++) {
				temp += shortArr[j] * longArr[j + i];
			}
			
			arrMSum = Math.max(arrMSum, temp);
		}
		
		return arrMSum;
	}
}

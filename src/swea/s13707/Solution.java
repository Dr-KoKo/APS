package swea.s13707;

import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);
	private static int T;

	public static void main(String[] args) {
		T = input.nextInt();
		input.nextLine();

		for (int tc = 1; tc <= T; tc++) {
			int n = input.nextInt();
			input.nextLine();

			char[][] arr = new char[n][n];
			for (int i = 0; i < n; i++) {
				arr[i] = input.nextLine().toCharArray();
			}

			arrange(arr);
			System.out.printf("#%d %d\n", tc, cal(arr));

		}

	}

	private static void arrange(char[][] arr) {
		int[] drA = { -1, 1, 0, 0 };
		int[] dcA = { 0, 0, -1, 1 };
		int[] drB = { -2, 2, 0, 0 };
		int[] dcB = { 0, 0, -2, 2 };
		int[] drC = { -3, 3, 0, 0 };
		int[] dcC = { 0, 0, -3, 3 };

		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[i].length; j++)
				switch (arr[i][j]) {
				case 'C':
					for (int j2 = 0; j2 < 4; j2++) {
						try {
							arr[i + drC[j2]][j + dcC[j2]] = 'X';
						} catch (ArrayIndexOutOfBoundsException e) {
							continue;
						}
					}
				case 'B':
					for (int j2 = 0; j2 < 4; j2++) {
						try {
							arr[i + drB[j2]][j + dcB[j2]] = 'X';
						} catch (ArrayIndexOutOfBoundsException e) {
							continue;
						}
					}
				case 'A':
					for (int j2 = 0; j2 < 4; j2++) {
						try {
							arr[i + drA[j2]][j + dcA[j2]] = 'X';
						} catch (ArrayIndexOutOfBoundsException e) {
							continue;
						}
					}
				default:
				}

	}

	private static int cal(char[][] arr) {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[i].length; j++)
				if (arr[i][j] == 'H')
					cnt++;

		return cnt;
	}
}

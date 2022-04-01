package s13705;

import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);
	private static StringBuilder sb = new StringBuilder();
	private static int T;
	private static int[][] arr;

	public static void main(String[] args) {
		T = input.nextInt();
		input.nextLine();

		for (int tc = 1; tc <= T; tc++) {
			int N = input.nextInt();
			int M = input.nextInt();
			int[] rc = { input.nextInt() - 1, input.nextInt() - 1 };
			int D = input.nextInt();
			input.nextLine();

			arr = new int[N][N];

			arrange(M,rc,D);
			
			int[] result = cal(arr);

			sb.append(String.format("#%d", tc));
			for (int i = 0; i < result.length; i++) {
				sb.append(" ").append(result[i]);
			}

			System.out.println(sb);

			sb.setLength(0);
		}
	}

	private static void arrange(int M, int[] rc, int D) {
		int i = 0;
		int N = D>0? Math.max(Math.max(rc[0], arr.length - rc[0]), Math.max(rc[1], arr.length - rc[1])):M / (-D);
		while (i <= N) {
			for (int j = -i; j <= i; j++)
				for (int j2 = -i; j2 <= i; j2++) {
					if (-i < j && j < i && -i < j2 && j2 < i)
						continue;
					try {
						arr[rc[0] + j][rc[1] + j2] += M + i * D;
					} catch (ArrayIndexOutOfBoundsException e) {

					}
				}
			i++;
		}
	}

	private static int[] cal(int[][] arr) {
		int[] sum = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] > 255) {
					sum[i] += 255;
					continue;
				}
				sum[i] += arr[i][j];
			}

		return sum;
	}
}

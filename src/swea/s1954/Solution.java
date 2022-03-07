package swea.s1954;

import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);
	private static int T;
	private static int[] dr = { 0, 1, 0, -1 };
	private static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		T = input.nextInt();
		input.nextLine();

		for (int tc = 1; tc <= T; tc++) {
			int N = input.nextInt();
			input.nextLine();

			int[][] arr = new int[N][N];
			snailize(arr);

			sb.append(String.format("#%d\n", tc));
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.print(sb);

			sb.setLength(0);

		}

	}

	private static void snailize(int[][] arr) {
		int cnt = 0;
		int[] temp = { 0, 0 };

		int i = 0;

		arr[temp[0]][temp[1]] = ++cnt;
		while (cnt < arr.length * arr.length) {
			if (temp[0] + dr[i % 4] < 0 || temp[0] + dr[i % 4] >= arr.length || temp[1] + dc[i % 4] < 0
					|| temp[1] + dc[i % 4] >= arr.length)
				i++;
			else if (arr[temp[0] + dr[i % 4]][temp[1] + dc[i % 4]] != 0)
				i++;
			
			arr[temp[0] + dr[i % 4]][temp[1] + dc[i % 4]] = ++cnt;

			temp[0] += dr[i % 4];
			temp[1] += dc[i % 4];

		}
	}

}

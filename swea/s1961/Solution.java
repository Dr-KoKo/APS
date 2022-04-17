package swea.s1961;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			int N = input.nextInt();
			input.nextLine();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = input.nextInt();
				}
			}
//			입력
			
			sb.append("#").append(tc).append("\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[N - 1 - j][i]);
				}
				sb.append(" ");

				for (int j = 0; j < N; j++) {
					sb.append(arr[N - 1 - i][N - 1 - j]);
				}
				sb.append(" ");

				for (int j = 0; j < N; j++) {
					sb.append(arr[j][N - 1 - i]);
				}
				sb.append("\n");

			}

			System.out.print(sb.toString());
		}

		input.close();
	}
}

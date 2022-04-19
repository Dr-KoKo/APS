package s1954;

import java.util.Scanner;

public class SolutionFinal {
	public static Scanner input = new Scanner(System.in);
	private static int T;
	private static int[] dr = { 0, 1, 0, -1 };
	private static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) {
//		StringBuilder sb = new StringBuilder();

		T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = input.nextInt();

			int[][] arr = new int[N][N];
			snailize(arr);

			System.out.printf("#%d\n", tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}

//			sb.append(String.format("#%d\n", tc));
//			for (int i = 0; i < arr.length; i++) {
//				for (int j = 0; j < arr[i].length; j++) {
//					sb.append(arr[i][j]).append(" ");
//				}
//				sb.append("\n");
//			}
//			System.out.print(sb);
//
//			sb.setLength(0);

		}

	}

	private static void snailize(int[][] arr) {
		int N = arr.length;
		int cnt = 0;
		int[] temp = { 0, 0 }; //현재 좌표

		int i = 0; // 방향

		arr[temp[0]][temp[1]] = ++cnt; //N=1일 때 초기화
		while (cnt < N * N) {
			try {
				if (arr[temp[0] + dr[i % 4]][temp[1] + dc[i % 4]] == 0) {
					arr[temp[0] + dr[i % 4]][temp[1] + dc[i % 4]] = ++cnt; // 값 입력
					temp[0] += dr[i % 4]; // 좌표 변경
					temp[1] += dc[i % 4];
				} else { // 값 있으면
					i++; // 방향 전환
				}
			} catch (IndexOutOfBoundsException e) { // index 밖
				i++; // 방향 전환
			}
		}

	}

}

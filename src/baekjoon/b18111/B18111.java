package baekjoon.b18111;

import java.util.Scanner;

public class B18111 {

	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();
		int M = input.nextInt();
		int B = input.nextInt();
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int temp = input.nextInt();

				map[i][j] = temp;
				max = Math.max(max, temp);
				min = Math.min(min, temp);
			}
		}
		
		

	}
}

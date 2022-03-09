package baekjoon.b18111;

import java.util.Scanner;

public class B18111_2 {

	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;

	public static int N, M, B;
	public static int[][] map;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		N = input.nextInt();
		M = input.nextInt();
		B = input.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int temp = input.nextInt();

				map[i][j] = temp;
				max = Math.max(max, temp);
				min = Math.min(min, temp);
			}
		}

		int ansFloor = -1;
		int start = min;
		int end = max;
		while (true) {
			int middle = (start + end) / 2;

			int S = checkTime(start);
			int M = checkTime(middle);
			int E = checkTime(end);

			if (checkTime(middle) == Integer.MAX_VALUE || ((S < M) && (M < E))) {
				end = middle - 1;
//				if (checkTime(middle) == Integer.MAX_VALUE)
//					System.out.println("블럭 부족 : end = middle");
//				System.out.println("단조증가 : end = middle");
			} else if ((S > M) && (M > E)) {
				start = middle + 1;
//				System.out.println("단조감소 : start = middle");
			} else if ((S > M) && (M < E)) {
				ansFloor = middle;
//				System.out.println("mid 발견");
				break;
			} else if ((S == M) || (M == E)) {
				if (S == M)
					ansFloor = middle;
				else if (M == E)
					ansFloor = middle + 1;
				break;
			}
		}

		System.out.println(checkTime(ansFloor) + " " + ansFloor);

		input.close();

	}

	private static int checkTime(int targetFloor) {
		int cntT = 0;
		int cntB = B;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int temp = map[i][j] - targetFloor;
				if (temp >= 0) {
					cntT += 2 * temp;
					cntB += temp;
				} else {
					cntT += 1 * (-temp);
					cntB += temp;
				}
			}
		}

		if (cntB < 0)
			return Integer.MAX_VALUE;
		return cntT;

	}
}

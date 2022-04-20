package s2068;

import java.util.Scanner;

// 2068.최대수 구하기
// 3항 연산자
public class Solution_2 {

	static Scanner input = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();

	private static int max;

	public static void main(String[] args) {

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			max = Integer.MIN_VALUE;

			for (int j = 0; j < 10; j++) {

				int temp = input.nextInt();

				max = max > temp ? max : temp;

			}

			stringBuild(tc, max);

		}

		System.out.print(sb);

		input.close();

	}

	private static void stringBuild(int tc, int ans) {

		sb.append("#").append(tc).append(" ").append(ans).append("\n");

	}

}
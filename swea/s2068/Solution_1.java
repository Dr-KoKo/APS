package swea.s2068;

import java.util.Scanner;

// 2068.최대수 구하기
// Math.max
public class Solution_1 {

	static Scanner input = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();

	private static int temp;

	public static void main(String[] args) {

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			temp = Integer.MIN_VALUE;

			for (int j = 0; j < 10; j++) {

				temp = Math.max(temp, input.nextInt());

			}

			stringBuild(tc, temp);

		}

		System.out.print(sb);

		input.close();

	}

	private static void stringBuild(int tc, int ans) {

		sb.append("#").append(tc).append(" ").append(ans).append("\n");

	}

}

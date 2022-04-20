package s2071;

import java.util.Scanner;

// 2071.평균값 구하기
// Math.round(x)
public class Solution_1 {

	static Scanner input = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = 10;

			double ans = 0;

			for (int i = 0; i < N; i++) {

				ans += input.nextDouble();

			}

			ans /= 10;

			stringBuild(tc, (int) Math.round(ans));

		}

		System.out.print(sb);

		input.close();

	}

	private static void stringBuild(int tc, int ans) {

		sb.append("#").append(tc).append(" ").append(ans).append("\n");

	}

}

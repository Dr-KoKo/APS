package swea.s1206;

import java.util.Scanner;

//1206. View
public class Solution_1 {

	static int ans;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			// 1. 입력
			int width = input.nextInt();

			int[] heights = new int[width];

			for (int i = 0; i < width; i++) {
				heights[i] = input.nextInt();
			}

			// 2. 초기화 및 계산
			ans = 0;

			for (int i = 2; i < width - 2; i++) {
				int hi = heights[i];
				int hj = Integer.MIN_VALUE;

				for (int j = -2; j <= 2; j++) {
					if (j == 0)
						continue;
					if (hj < heights[i + j])
						hj = heights[i + j];
				}

				if (hi - hj > 0)
					ans += hi - hj;
			}

			// 3. 출력
			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}

		System.out.println(sb);
		
		input.close();

	}

}

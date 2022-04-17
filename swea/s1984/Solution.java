package swea.s1984;

import java.util.Scanner;

public class Solution {
	static Scanner input = new Scanner(System.in);
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			double sum = 0.0;

			for (int i = 0; i < 10; i++) {
				int num = input.nextInt();
				max = Math.max(max, num);
				min = Math.min(min, num);
				sum += num;
			}

			int avgEdgeDel = (int) ((sum - max - min + 4) / 8);

			sb.append("#").append(tc).append(" ").append(avgEdgeDel).append("\n");

		}

		System.out.print(sb);

	}
}

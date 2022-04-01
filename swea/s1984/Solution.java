package s1984;

import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int max = 0;
			int min = 10000;
			double sum = 0.0;

			for (int i = 0; i < 10; i++) {
				int num = input.nextInt();
				max = Math.max(max, num);
				min = Math.min(min, num);
				sum += num;
			}
			int avgEdgeDel = (int) ((sum - max - min + 4) / 8);

			System.out.printf("#%d %d\n", tc, avgEdgeDel);
		}
	}

}

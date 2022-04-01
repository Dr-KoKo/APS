package s1208;

import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int D = input.nextInt();
			int[] cntHeights = new int[101];
			for (int i = 0; i < 100; i++) {
				++cntHeights[input.nextInt()];
			}

			System.out.printf("#%d %d\n", tc, cal(cntHeights, D));
		}

	}

	private static int cal(int[] target, int D) {
		int maxIdx = 100;
		int minIdx = 1;
		int dump = 0;

		while (true) {
			if (target[maxIdx] == 0) {
				--maxIdx;
				continue;
			}
			if (target[minIdx] == 0) {
				++minIdx;
				continue;
			}
			if (dump == D)
				break;

			--target[maxIdx];
			--target[minIdx];
			++target[maxIdx - 1];
			++target[minIdx + 1];

			++dump;
		}

		return (maxIdx - minIdx);
	}
}

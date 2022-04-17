package swea.s1225;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	private static boolean isFlag;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int[][] ans = new int[10 + 1][8];

		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int t = input.nextInt();
			Queue<Integer> code = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				code.add(input.nextInt());
			}

			cycle(code);

			for (int i = 0; i < 8; i++) {
				ans[tc][i] = code.remove();
			}
		}

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc);
			for (int i = 0; i < 8; i++) {
				sb.append(" ").append(ans[tc][i]);
			}

			System.out.println(sb.toString());
		}

		input.close();
	}

	private static void cycle(Queue<Integer> target) {
		outer: while (true) {
			for (int i = 1; i <= 5; i++) {
				Integer temp = target.remove();
				if (temp - i <= 0) {
					target.add(0);
					isFlag = false;
					break outer;
				} else {
					target.add(temp - i);
				}
			}
		}
	}

}

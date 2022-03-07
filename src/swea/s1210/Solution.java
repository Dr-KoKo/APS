package swea.s1210;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);
	private static int[][] ladderBoard = new int[100][100];

	public static void main(String[] args) {
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int t = input.nextInt();

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					ladderBoard[i][j] = input.nextInt();
				}
			}

			System.out.println("#%d %d\n", tc, find(ladderBoard));
		}
	}

	private static int find() {
		int[] des = new int[2];
		for (int i = 0; i < ladderArr[ladderArr.length - 1].length; i++) {
			if (ladderArr[ladderArr.length - 1][i] == 2)
				des[0] = ladderArr.length - 1;
			des[1] = i;
		}

		move(des);

	}

}

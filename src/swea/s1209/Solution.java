package swea.s1209;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int T = input.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int[][] board = new int[100][100]; // input을 여러곳에서 한번에 받을 수 있다면 편리할텐데.. (그런 방법이 있다던데..)
			for (int i = 0; i < 100; i++) 
				for (int j = 0; j < 100; j++) 
					board[i][j] = input.nextInt();	

			System.out.printf("#%d %d\n", tc, cal(board));
		}
	}

	public static int cal(int[][] target) {
		int rowMax = Integer.MIN_VALUE;
		int colMax = Integer.MIN_VALUE;
		int digSum1 = Integer.MIN_VALUE;
		int digSum2 = Integer.MIN_VALUE;

		for (int i = 0; i < target.length; i++) {
			int rowSum = 0;
			int colSum = 0;
			
			for (int j = 0; j < target.length; j++) {
				rowSum += target[i][j];
				colSum += target[j][i];
			}
			rowMax = Math.max(rowMax, rowSum);
			colMax = Math.max(colMax, colSum);
			
			digSum1 += target[i][i];
			digSum2 += target[i][99-i];
		}
		
		return Math.max(Math.max(rowMax, colMax), Math.max(digSum1, digSum2));
	}
}

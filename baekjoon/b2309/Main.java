package b2309;

import java.util.Scanner;

public class Main {
	public static Scanner input = new Scanner(System.in);

	private static int N;
	private static int[] heights;
	private static boolean[] isSel;
	private static boolean[] isSelFin;

	public static void main(String[] args) {
		N = 9;
		heights = new int[N];
		isSel = new boolean[N];
		isSelFin = new boolean[N];
		for (int i = 0; i < N; i++) {
			heights[i] = input.nextInt();
		}

		cal(0, 0);
		for (int i = 0; i < isSelFin.length; i++) {
			if (isSelFin[i])
				System.out.println(heights[i]);
		}
	}

	private static void cal(int idx, int sumHeight) {

		if (idx == 9) {
			if (sumHeight == 100) {
				for (int i = 0; i < isSel.length; i++) {
					
					isSelFin[i] = isSel[i];
				}
				return;
			}
			return;
		}

		isSel[idx] = false;
		cal(idx + 1, sumHeight);
		isSel[idx] = true;
		cal(idx + 1, sumHeight + heights[idx]);
	}
}

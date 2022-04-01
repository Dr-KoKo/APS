package b7568;

import java.util.Scanner;

public class B7568 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = input.nextInt();
		int[][] data = new int[N][2];
		for (int i = 0; i < data.length; i++) {
			data[i][0] = input.nextInt();
			data[i][1] = input.nextInt();
		}

		/*
		 * countsort int[][] sortedData1 = new int[N][2]; int[][] sortedData2 = new
		 * int[N][2];
		 * 
		 * int[] cntW = new int[201]; int[] cntH = new int[201];
		 * 
		 * 
		 * for (int d = 0; d < N; d++) { cntW[data[d][0]]++; cntH[data[d][1]]++; }
		 * 
		 * for (int i = N-1; i >= 0; i++) { sortedData1[--cntW[data[i][0]]] = data[i]; }
		 * 
		 * for (int i = N-1; i >= 0; i++) { sortedData2[--cntH[data[i][1]]] =
		 * sortedData1[i]; }
		 */

		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N; j++) {
				if (data[j][0] > data[i][0] && data[j][1] > data[i][1])
					cnt++;
			}
			sb.append(cnt).append(" ");
		}

		sb.setLength(sb.length() - 1);

		System.out.println(sb);

		input.close();

	}
}

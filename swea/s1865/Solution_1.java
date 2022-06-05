package s1865;

import java.util.Scanner;

public class Solution_1 {

	static int N;
	static double[][] chance;
	static double ans;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = input.nextInt();

			chance = new double[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					chance[i][j] = input.nextDouble() / 100;
				}
			}
			
			ans = 1;
			
			boolean[] check = new boolean[N];
			preDFS(0, 100, check);

			check = new boolean[N];
			DFS(0, 100, check);

			ans = Math.round(ans*1000000)/1000000.0;
			
			sb.append("#").append(tc).append(" ").append(String.format("%.6f", ans)).append("\n");
			
		}
		
		System.out.print(sb);
		
	}

	private static void preDFS(int idx, int total, boolean[] check) {
		if (idx == N) {
			ans = total;
			return;
		}

		double max = Double.MIN_VALUE;
		int maxIdx = -1;
		for (int i = 0; i < N; i++) {
			if(chance[idx][i]>max&&!check[i]) {
				max =chance[idx][i];
				maxIdx =i;
			}
		}
		
		check[maxIdx] = true;
		DFS(idx + 1, total * chance[idx][maxIdx], check);
		check[maxIdx] = false;
		
	}

	private static void DFS(int idx, double total, boolean[] check) {

		if (total < ans) {
			return;
		}

		if (idx == N && total > ans) {
			ans = total;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				DFS(idx + 1, total * chance[idx][i], check);
				check[i] = false;
			}
		}

	}

}

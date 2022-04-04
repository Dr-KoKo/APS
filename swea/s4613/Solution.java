package s4613;

import java.util.Scanner;

public class Solution {
	
	private static int N,M;
	private static int WBLine,BRLine;
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			N = input.nextInt();
			M = input.nextInt();
			input.nextLine();
			
			char[][] flag = new char[N][M];
			
			for (int i = 0; i < N; i++) {
				
				flag[i] = input.nextLine().toCharArray();
				
			}

			int ans = combWithFor(flag);
//			int ans = comb(flag);
//			int ans = comb(flag);
			

		}
		
		input.close();
		
	}
	
	private static int combWithFor(char[][] flag) {
		
		int sumMin = Integer.MAX_VALUE;

		for (int WBLine = 1; WBLine < N - 1; WBLine++) {
			for (int BRLine = WBLine + 1; BRLine < N; BRLine++) {
				
				int sum = 0;

				for (int w = 0; w < WBLine; w++) {
					for (int m = 0; m < M; m++) {
						if (flag[w][m] != 'W')
							sum++;
					}
				}
				
				for (int b = WBLine; b < BRLine; b++) {
					for (int m = 0; m < M; m++) {
						if (flag[b][m] != 'B')
							sum++;
					}
				}
				
				for (int r = BRLine; r < N; r++) {
					for (int m = 0; m < M; m++) {
						if (flag[r][m] != 'R')
							sum++;
					}
				}
				
				sumMin = Math.min(sumMin, sum);
				
			}
			
		}
		
		return sumMin;
		
	}
	
}

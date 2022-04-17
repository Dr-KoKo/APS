package swea.s7102;

import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);
	private static int N, M;
	private static int[] ans;
	
	public static void main(String[] args) {
		int T = input.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			N = input.nextInt();
			M = input.nextInt();
			ans = new int[41];
			int max = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					ans[i+j]++;
					max = Math.max(max, ans[i+j]);
				}
			}
			
			sb.append("#").append(tc);
			for (int i = 0; i < 40; i++) {
				if(ans[i]==max)
					sb.append(" ").append(i);
			}
			
			System.out.println(sb);
			
		}
	}
	
}

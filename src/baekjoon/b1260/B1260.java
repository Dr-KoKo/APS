package baekjoon.b1260;

import java.util.Scanner;

public class B1260 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		int M = input.nextInt();
		int V = input.nextInt();
		
		boolean[][] tree = new boolean[N+1][N+1];
		for (int m = 0; m < M; m++) {
			int p = input.nextInt();
			int c = input.nextInt();
			tree[p][c] = true;
			tree[c][p] = true;
		}
		
		for (int i = 0; i < tree.length; i++) {
			
		}
		
	}
	
	
	
}

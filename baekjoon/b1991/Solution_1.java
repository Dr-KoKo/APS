package b1991;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1 {

	static Scanner input = new Scanner(System.in);

	static int N;
	static int[][] edges;

	public static void main(String[] args) {

		N = Integer.parseInt(input.nextLine());

		edges = new int[N][3];
		for (int i = 0; i < N; i++) {
			edges[i][0] = input.next().charAt(0) - 'A';
			edges[i][1] = input.next().charAt(0) - 'A';
			edges[i][2] = input.next().charAt(0) - 'A'; // . = -19
		}

		front();

	}

	private static void front() {

		boolean[] visited = new boolean[N];
		int[] ans = new int[N];

		frontUtil(0, 0, visited, ans);

		for (int i = 0; i < ans.length; i++) {
			System.out.printf("%c", ans[i] + 'A');
		}
	}

	private static void frontUtil(int idx, int node, boolean[] visited, int[] ans) {

		if (idx == N)
			return;

		if(node==-19||visited[node])
			return;

		visited[node] = true;
		ans[idx] = edges[node][0];

		frontUtil(idx + 1, edges[node][0], visited, ans);
		frontUtil(idx + 1, edges[node][1], visited, ans);

	}

}

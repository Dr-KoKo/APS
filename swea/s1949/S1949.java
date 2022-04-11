package s1949;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class S1949 {

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int drc[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static int N, K;
	static int[][] mountain;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = input.nextInt();
			K = input.nextInt();
			int max = Integer.MIN_VALUE;

			mountain = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					mountain[i][j] = input.nextInt();
					if (mountain[i][j] > max)
						max = mountain[i][j];

				}
			}

			List<Pos> tip = new LinkedList<>();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (mountain[i][j] == max)
						tip.add(new Pos(i,j));

				}
			}
			
			BFS();

		}

		input.close();

	}

	private static void BFS() {

		boolean[][] visited = new boolean[N][N];

//		BFSUtil(0, visited);

	}


}
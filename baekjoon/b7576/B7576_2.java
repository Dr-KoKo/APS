package b7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7576_2 {

	private static int[][] box;
	private static boolean[][] empty;
	private static int M, N;
	private static int ans = 0;

	private static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int M = input.nextInt();
		int N = input.nextInt();

		int[][] box = new int[N][M];

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {

				box[i][j] = input.nextInt();

			}

		}

		BFS();

	}

	private static void BFS() {

		outer: for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {

				if (box[i][j] == 1) {

					boolean[][] visited = empty; // 필요시 deepcopy해서 사용
					
					int ret = BFSUtil(i, j, visited);

					
					if (ret == -1) {
						ans = -1;
						break outer;
					} else {
						ans = Math.max(ans, ret);
					}

				}

			}

		}

	}

	private static int BFSUtil(int x, int y, boolean[][] visited) {

		Queue<int[]> queue = new LinkedList<>();

		int ansDay = -1;

		queue.add(new int[] { x, y });

		visited[x][y] = true;

		while (!queue.isEmpty()) {

			int size = queue.size();

			ansDay++;

			for (int e = 0; e < size; e++) {

				int[] n = queue.poll();

				if (box[n[0]][n[1]] == 1) {
					return ansDay;
				}
			}

		}
		return 0;
	}

}

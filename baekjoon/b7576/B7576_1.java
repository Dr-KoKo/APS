package b7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7576_1 {

	private static int[][] box;
	private static int M, N;
	private static int ans = 0;

	private static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		M = input.nextInt();
		N = input.nextInt();

		box = new int[N][M];

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {

				box[i][j] = input.nextInt();

			}

		}

		BFS();

		input.close();

	}

	private static void BFS() {

		outer: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (box[i][j] == 0) {

					boolean[][] visited = new boolean[N][M];
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

		System.out.println(ans);

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

				for (int i = 0; i < drc.length; i++) {

					int nx = n[0] + drc[i][0];
					int ny = n[1] + drc[i][1];

					if (inBound(nx, ny) && !visited[nx][ny] && box[nx][ny] != -1) {
						queue.add(new int[] { nx, ny });
						visited[nx][ny] = true;
					}

				}
			}

		}

		return -1;

	}

	private static boolean inBound(int nx, int ny) {
		return nx >= 0 && nx < N && ny >= 0 && ny < M;
	}

}

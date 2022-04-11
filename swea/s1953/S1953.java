package s1953;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1953 {

	static enum drc {
		Right(0, 1), Left(0, -1), Top(-1, 0), Down(1, 0);

		int x, y;

		private drc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] map;
	static boolean[][] visited;
	static int N, M, R, C, L;
	static int ans;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = input.nextInt();
			M = input.nextInt();

			R = input.nextInt();
			C = input.nextInt();

			L = input.nextInt();

			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = input.nextInt();
				}
			}

			BFS();

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}

		System.out.print(sb);

		input.close();

	}

	private static void BFS() {

		ans = 0;
		visited = new boolean[N][M];

		Queue<Pos> queue = new LinkedList<>();
		int cnt = 0;

		queue.add(new Pos(R, C));
		visited[R][C] = true;

		while (!queue.isEmpty()) {

			int size = queue.size();
			ans += size;

			cnt++;
			
			if (cnt == L)
				break;
			
			for (int i = 0; i < size; i++) {

				Pos pos = queue.poll();
				move(queue, pos);

			}

		}

	}

	private static void move(Queue<Pos> queue, Pos pos) {
		switch (map[pos.x][pos.y]) {
		case 1:
			for (drc d : drc.values()) {
				int nx = pos.x + d.x;
				int ny = pos.y + d.y;

				if (!inBound(nx, ny) || !movable(d, map[nx][ny]) || visited[nx][ny]) {
					continue;
				}

				if (map[nx][ny] != 0) {
					queue.add(new Pos(nx, ny));
					visited[nx][ny] = true;
				}
			}
			break;
		case 2:
			for (drc d : new drc[] { drc.Top, drc.Down }) {
				int nx = pos.x + d.x;
				int ny = pos.y + d.y;

				if (!inBound(nx, ny) || !movable(d, map[nx][ny]) || visited[nx][ny]) {
					continue;
				}

				if (map[nx][ny] != 0) {
					queue.add(new Pos(nx, ny));
					visited[nx][ny] = true;
				}
			}
			break;
		case 3:
			for (drc d : new drc[] { drc.Left, drc.Right }) {
				int nx = pos.x + d.x;
				int ny = pos.y + d.y;

				if (!inBound(nx, ny) || !movable(d, map[nx][ny]) || visited[nx][ny]) {
					continue;
				}

				if (map[nx][ny] != 0) {
					queue.add(new Pos(nx, ny));
					visited[nx][ny] = true;
				}
			}
			break;
		case 4:
			for (drc d : new drc[] { drc.Top, drc.Right }) {
				int nx = pos.x + d.x;
				int ny = pos.y + d.y;

				if (!inBound(nx, ny) || !movable(d, map[nx][ny]) || visited[nx][ny]) {
					continue;
				}

				if (map[nx][ny] != 0) {
					queue.add(new Pos(nx, ny));
					visited[nx][ny] = true;
				}
			}
			break;
		case 5:
			for (drc d : new drc[] { drc.Down, drc.Right }) {
				int nx = pos.x + d.x;
				int ny = pos.y + d.y;

				if (!inBound(nx, ny) || !movable(d, map[nx][ny]) || visited[nx][ny]) {
					continue;
				}

				if (map[nx][ny] != 0) {
					queue.add(new Pos(nx, ny));
					visited[nx][ny] = true;
				}
			}
			break;
		case 6:
			for (drc d : new drc[] { drc.Left, drc.Down }) {
				int nx = pos.x + d.x;
				int ny = pos.y + d.y;

				if (!inBound(nx, ny) || !movable(d, map[nx][ny]) || visited[nx][ny]) {
					continue;
				}

				if (map[nx][ny] != 0) {
					queue.add(new Pos(nx, ny));
					visited[nx][ny] = true;
				}
			}
			break;
		case 7:
			for (drc d : new drc[] { drc.Left, drc.Top }) {
				int nx = pos.x + d.x;
				int ny = pos.y + d.y;

				if (!inBound(nx, ny) || !movable(d, map[nx][ny]) || visited[nx][ny]) {
					continue;
				}

				if (map[nx][ny] != 0) {
					queue.add(new Pos(nx, ny));
					visited[nx][ny] = true;
				}
			}
			break;
		}
	}

	private static boolean movable(drc d, int next) {

		if (d == d.Right && (next == 2 || next == 4 || next == 5))
			return false;
		else if (d == d.Down && (next == 3 || next == 5 || next == 6))
			return false;
		else if (d == d.Left && (next == 2 || next == 6 || next == 7))
			return false;
		else if (d == d.Top && (next == 3 || next == 4 || next == 7))
			return false;

		return true;
	}

	private static boolean inBound(int nx, int ny) {
		return nx >= 0 && nx < N && ny >= 0 && ny < M;
	}

}

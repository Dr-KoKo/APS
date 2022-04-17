package swea.s5650;

import java.util.Scanner;

public class S5650_1 {

	enum drc {
		Right(0, 1), Down(1, 0), Left(0, -1), Top(-1, 0);

		int r, c;

		private drc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N;
	static int ans;
	static int[][] map;
	static Pos start;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = input.nextInt();

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = input.nextInt();
				}
			}

			DFS();

			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}

		System.out.print(sb);

		input.close();

	}

	private static void DFS() {

		ans = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (map[i][j] == 0) {
					start = new Pos(i, j);

					for (drc d : drc.values()) {
						DFSUtil(new Pos(i + d.r, j + d.c), d, 0);
					}
				}
			}
		}

	}

	private static void DFSUtil(Pos curr, drc d, int value) {

		int r = curr.r;
		int c = curr.c;

		if (!inBound(r, c)) {
			if (d == drc.Right)
				DFSUtil(new Pos(r + drc.Left.r, c + drc.Left.c), drc.Left, value + 1);
			else if (d == drc.Top)
				DFSUtil(new Pos(r + drc.Down.r, c + drc.Down.c), drc.Down, value + 1);
			else if (d == drc.Left) {
				DFSUtil(new Pos(r + drc.Right.r, c + drc.Right.c), drc.Right, value + 1);
			} else if (d == drc.Down)
				DFSUtil(new Pos(r + drc.Top.r, c + drc.Top.c), drc.Top, value + 1);
			return;
		}

		if (map[r][c] == -1 || (r == start.r && c == start.c)) {
			ans = Math.max(ans, value);
			return;
		}

		switch (map[r][c]) {
		case 0:
			int nr = r + d.r;
			int nc = c + d.c;
			DFSUtil(new Pos(nr, nc), d, value);
			break;
		case 1:
			if (d == drc.Right)
				DFSUtil(new Pos(r + drc.Left.r, c + drc.Left.c), drc.Left, value + 1);
			else if (d == drc.Top)
				DFSUtil(new Pos(r + drc.Down.r, c + drc.Down.c), drc.Down, value + 1);
			else if (d == drc.Left)
				DFSUtil(new Pos(r + drc.Top.r, c + drc.Top.c), drc.Top, value + 1);
			else if (d == drc.Down)
				DFSUtil(new Pos(r + drc.Right.r, c + drc.Right.c), drc.Right, value + 1);
			break;
		case 2:
			if (d == drc.Right)
				DFSUtil(new Pos(r + drc.Left.r, c + drc.Left.c), drc.Left, value + 1);
			else if (d == drc.Top)
				DFSUtil(new Pos(r + drc.Right.r, c + drc.Right.c), drc.Right, value + 1);
			else if (d == drc.Left)
				DFSUtil(new Pos(r + drc.Down.r, c + drc.Down.c), drc.Down, value + 1);
			else if (d == drc.Down)
				DFSUtil(new Pos(r + drc.Top.r, c + drc.Top.c), drc.Top, value + 1);
			break;
		case 3:
			if (d == drc.Right)
				DFSUtil(new Pos(r + drc.Down.r, c + drc.Down.c), drc.Down, value + 1);
			else if (d == drc.Top)
				DFSUtil(new Pos(r + drc.Left.r, c + drc.Left.c), drc.Left, value + 1);
			else if (d == drc.Left)
				DFSUtil(new Pos(r + drc.Right.r, c + drc.Right.c), drc.Right, value + 1);
			else if (d == drc.Down)
				DFSUtil(new Pos(r + drc.Top.r, c + drc.Top.c), drc.Top, value + 1);
			break;
		case 4:
			if (d == drc.Right)
				DFSUtil(new Pos(r + drc.Top.r, c + drc.Top.c), drc.Top, value + 1);
			else if (d == drc.Top)
				DFSUtil(new Pos(r + drc.Down.r, c + drc.Down.c), drc.Down, value + 1);
			else if (d == drc.Left)
				DFSUtil(new Pos(r + drc.Right.r, c + drc.Right.c), drc.Right, value + 1);
			else if (d == drc.Down)
				DFSUtil(new Pos(r + drc.Left.r, c + drc.Left.c), drc.Left, value + 1);
			break;
		case 5:
			if (d == drc.Right)
				DFSUtil(new Pos(r + drc.Left.r, c + drc.Left.c), drc.Left, value + 1);
			else if (d == drc.Top)
				DFSUtil(new Pos(r + drc.Down.r, c + drc.Down.c), drc.Down, value + 1);
			else if (d == drc.Left)
				DFSUtil(new Pos(r + drc.Right.r, c + drc.Right.c), drc.Right, value + 1);
			else if (d == drc.Down)
				DFSUtil(new Pos(r + drc.Top.r, c + drc.Top.c), drc.Top, value + 1);
			break;
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
			Pos worm = find(map[r][c], r, c);
			DFSUtil(new Pos(worm.r + d.r, worm.c + d.c), d, value);
			break;

		}

	}

	private static boolean inBound(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	private static Pos find(int w, int r, int c) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == r && j == c)
					continue;
				if (map[i][j] == w)
					return new Pos(i, j);
			}
		}
		return null;

	}

}

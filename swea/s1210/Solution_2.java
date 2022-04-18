package s1210;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_2 {

	enum drc {
		Right(0, 1), Left(0, -1), Top(-1, 0);

		int dr, dc;

		private drc(int dr, int dc) {
			this.dr = dr;
			this.dc = dc;
		}
	}

	static int[][] map;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {

			input.nextLine();

			map = new int[100][100];

			for (int i = 0; i < 100; i++) {
				map[i] = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			int ans = -1;
			for (int i = 0; i < 100; i++) {
				if (map[99][i] == 2) {
					int r = 99;
					int c = i;

					loop: while (true) {
						for (drc d : drc.values()) {
							int nr = r + d.dr;
							int nc = c + d.dc;

							if (!inBound(nr, nc)||map[nr][nc]==0)
								continue;

							if (d != drc.Top) {
								while (inBound(nr + d.dr, nc + d.dc) && map[nr + d.dr][nc + d.dc] == 1) {
									nr += d.dr;
									nc += d.dc;
								}
								r = nr;
								c = nc;
							} else if (d == drc.Top) {
								while (inBound(nr + d.dr, nc + d.dc) && map[nr + drc.Right.dr][nc + drc.Right.dc] != 1
										&& map[nr + drc.Left.dr][nc + drc.Left.dc] != 1) {
									nr += d.dr;
									nc += d.dc;
								}

								if (nr == 0) {
									ans = nc;
									break loop;
								}

								r = nr;
								c = nc;
							}

						}
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}

		System.out.print(sb);

	}

	private static boolean inBound(int nr, int nc) {
		return nr >= 0 && nr < 100 && nc >= 0 && nc < 100;
	}
}

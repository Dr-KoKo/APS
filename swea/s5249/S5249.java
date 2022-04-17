package s5249;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class S5249 {

	static int V, E;
	static int[] p;
	static int[][] edges;
	static int ans;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			V = input.nextInt();
			E = input.nextInt();

			edges = new int[E][3];
			for (int i = 0; i < E; i++) {

				edges[i][0] = input.nextInt();
				edges[i][1] = input.nextInt();
				edges[i][2] = input.nextInt();

			}

			Arrays.sort(edges, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});

			p = new int[V + 1];
			for (int i = 0; i <= V; i++) {
				p[i] = i;
			}

			ans = 0;
//			int pick = 0;
			for (int i = 0; i < E; i++) {

				int px = findSet(edges[i][0]);
				int py = findSet(edges[i][1]);

				if (px == py)
					continue;
				else {
					union(px, py);
					ans += edges[i][2];
//					++pick;
				}

//				if(pick==V-1)
//					break;

			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}

		System.out.print(sb);

		input.close();

	}

	private static void union(int px, int py) {

		p[px] = py;

	}

	private static int findSet(int x) {

		if (p[x] == x)
			return x;
		else
			return p[x] = findSet(p[x]);

	}

}

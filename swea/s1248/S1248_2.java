package s1248;

import java.io.IOException;
import java.util.Scanner;

public class S1248_2 {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = input.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int V = input.nextInt();
			int E = input.nextInt();
			int F1 = input.nextInt();
			int F2 = input.nextInt();

			int[][] tree = new int[V + 1][3];
			for (int e = 0; e < E; e++) {
				int p = input.nextInt();
				int c = input.nextInt();

				if (tree[p][1] == 0)
					tree[p][1] = c;
				else
					tree[p][2] = c;

				tree[c][0] = p;
			}

			findNode(tree, F1);
			int X = findNode(tree, F2);

			sb.append("#").append(tc);
			sb.append(" ").append(X);
			sb.append(" ").append(cntChildNode(tree, X));
			sb.append("\n");
		}

		System.out.print(sb);

	}

	private static int cntChildNode(int[][] tree, int x) {
		int ret = 1;
		
		if (tree[x][1] != 0) {
			ret += cntChildNode(tree, tree[x][1]);
		}
		if (tree[x][2] != 0) {
			ret +=cntChildNode(tree, tree[x][2]);
		}

		return ret;
		
	}

	private static int findNode(int[][] tree, int f1) {
		while (f1 != 1) {
			if (tree[f1][0] == -1)
				return f1;
			int temp = tree[f1][0];
			tree[f1][0] = -1;
			f1 = temp;
		}
		return f1;
	}
}


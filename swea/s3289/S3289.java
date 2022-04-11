package s3289;

import java.util.Scanner;

public class S3289 {

	static int[] p;
	static int[] rank;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = input.nextInt();
			int M = input.nextInt();

			initiate(N);

			sb.append("#").append(tc).append(" ");

			for (int i = 0; i < M; i++) {
				int order = input.nextInt();
				switch (order) {
				case 1:
					if (findSet(input.nextInt()) == findSet(input.nextInt()))
						sb.append(1);
					else
						sb.append(0);
					break;
				case 0:
					merge(input.nextInt(), input.nextInt());
					break;
				}
			}

			sb.append("\n");

		}

		System.out.print(sb);

		input.close();

	}

	private static void initiate(int N) {

		p = new int[N + 1];
		rank = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			p[i] = i;
			rank[i] = 0;
		}

	}

	private static void merge(int nextInt, int nextInt2) {

		link(findSet(nextInt), findSet(nextInt2));

	}

	private static void link(int findSet, int findSet2) {

		if (rank[findSet] > rank[findSet2])
			p[findSet2] = findSet;
		else {
			p[findSet] = findSet2;
			if (rank[findSet] == rank[findSet2])
				++rank[findSet2];
		}

	}

	private static int findSet(int x) {

		if (x == p[x])
			return x;
		else
			return p[x] = findSet(p[x]);

	}
}

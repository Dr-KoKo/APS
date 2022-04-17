package s7465;

import java.util.HashSet;
import java.util.Scanner;

public class S7465 {

	static int[] p;
	static int[] rank;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int people = input.nextInt();
			initiateSet(people);

			int relation = input.nextInt();
			for (int i = 0; i < relation; i++) {
				union(input.nextInt(), input.nextInt());
			}

			for (int i = 1; i <= people; i++) {
				findSet(i);
			}

			HashSet<Integer> leader = new HashSet<>();
			for (int i = 1; i <= people; i++) {
				leader.add(p[i]);
			}

			sb.append("#").append(tc).append(" ").append(leader.size()).append("\r\n");

		}

		System.out.print(sb);

		input.close();

	}

	private static void initiateSet(int people) {

		p = new int[people + 1];
		rank = new int[people + 1];

		makeAllSet(people);

	}

	private static void makeAllSet(int people) {

		for (int i = 0; i <= people; i++) {
			makeSet(i);
		}

	}

	private static void makeSet(int n) {

		p[n] = n;
		rank[n] = 0;

	}

	private static void union(int nextInt, int nextInt2) {

		link(findSet(nextInt), findSet(nextInt2));

	}

	private static void link(int findSet, int findSet2) {

		if (rank[findSet] > rank[findSet2]) {
			p[findSet2] = p[findSet];
		} else {
			p[findSet] = p[findSet2];
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

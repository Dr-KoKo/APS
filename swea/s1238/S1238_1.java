package swea.s1238;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class S1238_1 {

	static List<Integer>[] contacts;
	static boolean[] visited;
	static int[] p;
	static int ans;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int tc = 1;

		while (tc <= 10) {
			int N = input.nextInt();
			int starter = input.nextInt();

			contacts = new LinkedList[101];
			for (int i = 0; i < 101; i++) {
				contacts[i] = new LinkedList<>();
			}

			for (int i = 0; i < N / 2; i++) {
				int caller = input.nextInt();
				int receiver = input.nextInt();

				contacts[caller].add(receiver);
			}

			process(starter);

			sb.append("#").append(tc++).append(" ").append(ans).append("\n");

		}

		System.out.print(sb);

	}

	private static void process(int starter) {

		Queue<Integer> queue = new LinkedList<>();
		visited = new boolean[101];
		List<Integer> curr = new LinkedList<>();

		queue.add(starter);
		visited[starter] = true;
		curr.add(starter);

		while (true) {

			int size = queue.size();

			if (size == 0) {
				Collections.sort(curr, Collections.reverseOrder());
				ans = curr.get(0);
				break;
			}

			curr = new LinkedList<>();

			for (int i = 0; i < size; i++) {

				int person = queue.poll();

				curr.add(person);

				Iterator<Integer> it = contacts[person].iterator();

				while (it.hasNext()) {
					int nextP = it.next();

					if (visited[nextP])
						continue;

					queue.add(nextP);
					visited[nextP] = true;
				}

			}

		}

	}

}
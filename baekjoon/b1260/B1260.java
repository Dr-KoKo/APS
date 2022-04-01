package b1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B1260 {

	private static LinkedList<Integer>[] adj;
	private static int N;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer input = new StringTokenizer(br.readLine());
		N = Integer.parseInt(input.nextToken());
		int M = Integer.parseInt(input.nextToken());
		int V = Integer.parseInt(input.nextToken());

		adj = new LinkedList[N+1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new LinkedList();
		}
		
		for (int i = 0; i < M; i++) {
			input = new StringTokenizer(br.readLine());
			int head = Integer.parseInt(input.nextToken());
			int tail = Integer.parseInt(input.nextToken());

			adj[head].add(tail);
			adj[tail].add(head);
		}
		for (int i = 1; i <= N; i++) {
			adj[i].sort(Comparator.naturalOrder());
		}

		DFS(V);
		BFS(V);

		System.out.print(sb);
	}

	private static void DFS(int v) {
		boolean[] visited = new boolean[N+1];
		DFSUtil(v, visited);
		sb.append("\n");
	}

	private static void DFSUtil(int v, boolean[] visited) {
		visited[v] = true;
		sb.append(v).append(" ");

		Iterator<Integer> it = adj[v].listIterator();
		while (it.hasNext()) {
			int n = it.next();
			if (!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}

	private static void BFS(int v) {
		boolean[] visited = new boolean[N+1];
		LinkedList<Integer> queue = new LinkedList<>();

		visited[v] = true;
		sb.append(v).append(" ");
		queue.add(v);

		while (queue.size() != 0) {
			v = queue.poll();

			Iterator<Integer> it = adj[v].listIterator();
			while (it.hasNext()) {
				int n = it.next();
				if (!visited[n]) {
					visited[n] = true;
					sb.append(n).append(" ");
					queue.add(n);
				}
			}
		}
		sb.append("\n");
	}

}

package b2606;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class B2606 {
	
	private static List<Integer>[] edge;
	
	private static int N;

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		// N : 총 노드의 수
		N = input.nextInt();
		// edge : 간선의 정보를 저장할 List. LinkedList[]배열로 구현.
		edge = new LinkedList[N+1];
		
		for (int i = 0; i <= N; i++) {
			
			edge[i] = new LinkedList<>();
			
		}
		// E : 총 입력의 수
		int E = input.nextInt();
		
		for (int e = 0; e < E; e++) {
			// 입력정보를 임시 저장해서
			int first = input.nextInt();
			int second = input.nextInt();
			// 간선 정보를 입력
			edge[first].add(second);
			edge[second].add(first);
			
		}
		
		System.out.println(DFS(1));
		
		input.close();
		
	}
	
	/**
	 * DFS를 실행할 때마다 방문체크를 위한 visited배열 생성.
	 * @param n : 시작노드
	 * @return (시작노드를 제외한) 감염된 총 컴퓨터의 수 
	 */
	private static int DFS (int n) {
		// 방문체크를 위한 visited배열 생성
		boolean[] visited = new boolean[N+1];
		// DFS 실행
		DFSUtil(n,visited);
		
		int ans = 0;
		
		for (int i = 0; i < visited.length; i++) {
			
			if(i==n)
				continue;
			
			if(visited[i])
				++ans;
			
		}
		
		return ans;
		
	}
	
	/**
	 * DFS 실행 함수
	 * @param i : 방문 노드
	 * @param visited : 방문체크를 위한 visited배열
	 */
	private static void DFSUtil(int i, boolean[] visited) {
		// 방문체크
		visited[i] = true;
		// 간선확인
		Iterator<Integer> it = edge[i].iterator();
		// 간선이 있으면
		while(it.hasNext()) {
			// 다음 노드를 탐색하여
			int n = it.next();
			// 방문체크가 되어있지 않으면 DFS 실행
			if(!visited[n])
				DFSUtil(n, visited);
			
		}
		
	}
	
}

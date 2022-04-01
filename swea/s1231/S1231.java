package s1231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S1231 {
	private static StringBuilder sb;
	private static Map<Integer, Character> map;

	public static void main(String[] args) throws IOException {
		//BufferedReader 선언 및 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//총 Test 수
		int T = 10;
		//Test 실행
		for (int tc = 1; tc <= T; tc++) {
			// StringBuilder, Map 초기화
			sb = new StringBuilder();
			map = new HashMap<>();
			//N(총 노드 수) 입력
			int N = Integer.parseInt(br.readLine());
			//tree구현을 위한 2차원 배열 생성
			int[][] tree = new int[N+1][3];
			//tree입력
			for (int i = 0; i < N; i++) {

				StringTokenizer input = new StringTokenizer(br.readLine());
				//n(노드번호), nChar(n노드에 해당하는 문자)
				int n = Integer.parseInt(input.nextToken());
				char nChar = input.nextToken().charAt(0);
				//map에 데이터 입력
				map.put(n, nChar);
				//(입력값이 있으면) 자식노드 입력(1회)
				if (input.hasMoreTokens()) {
					int child = Integer.parseInt(input.nextToken());
					if (tree[n][1] == 0) {
						tree[n][1] = child;
						tree[child][0] = n;
					}
					else {
						tree[n][2] = child;
						tree[child][0] = n;
					}
				}
				//(입력값이 있으면) 자식노드 입력(2회)
				if (input.hasMoreTokens()) {
					int child = Integer.parseInt(input.nextToken());
					if (tree[n][1] == 0) {
						tree[n][1] = child;
						tree[child][0] = n;
					}
					else {
						tree[n][2] = child;
						tree[child][0] = n;
					}
				}

			}
			//sb빌드
			sb.append("#").append(tc).append(" ");
			
			traverse(tree, 1);

			sb.append("\n");
			
			System.out.print(sb);
		}

		
	}

	private static void traverse(int[][] tree, int i) {
		if (tree[i][1] != 0)
			traverse(tree, tree[i][1]);

		sb.append(map.get(i));
		
		if(tree[i][2]!=0)
			traverse(tree,tree[i][2]);
	}
}

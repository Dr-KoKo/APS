package s1232;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S1232 {
	private static Map<Integer, Integer> mapNum;
	private static Map<Integer, Character> mapOp;
	private static int[][] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer input;
		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {

			mapNum = new HashMap<>();
			mapOp = new HashMap<>();

			int N = Integer.parseInt(br.readLine());

			tree = new int[N + 1][3];

			for (int i = 0; i < N; i++) {

				input = new StringTokenizer(br.readLine());

				int cntToken = input.countTokens();

				if (cntToken == 4) {

					int n = Integer.parseInt(input.nextToken());
					char op = input.nextToken().charAt(0);

					mapOp.put(n, op);

					int child_1 = Integer.parseInt(input.nextToken());
					int child_2 = Integer.parseInt(input.nextToken());

					tree[n][1] = child_1;
					tree[n][2] = child_2;
					tree[child_1][0] = n;
					tree[child_2][0] = n;

				} else if (cntToken == 2) {

					int n = Integer.parseInt(input.nextToken());
					int value = Integer.parseInt(input.nextToken());

					mapNum.put(n, value);
				}

			}

			sb.append("#").append(tc);
			
			int result = (int)operate(1);
			
			sb.append(" ").append(result);
			
			sb.append("\n");
			
		}
		
		System.out.print(sb);
		
	}

	private static double operate(int n) {
		
		if (mapOp.containsKey(n)) {
			return cal(mapOp.get(n),operate(tree[n][1]),operate(tree[n][2]));
		} else if(mapNum.containsKey(n)) {
			return mapNum.get(n);
		}
		
		return Double.MIN_VALUE;
		
	}

	private static double cal(char op, double x, double y) {

		switch (op) {
		case '+':
			return x + y;
		case '-':
			return x - y;
		case '*':
			return x * y;
		case '/':
			return x / y;
		}

		return Double.MIN_VALUE;
	}

}

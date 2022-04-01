package b1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1874 {

	private static Stack<Integer> stack = new Stack<>();
	private static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] series = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			series[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			if (cnt < series[i]) {
				while (true) {
					if (cnt == series[i]) {
						stack.pop();
						sb.append("-").append("\n");
						break;
					}
					stack.push(++cnt);
					sb.append("+").append("\n");
				}
			} else if (cnt > series[i]) {
				while (true) {
					if (stack.isEmpty() || stack.peek() < series[i]) {
						System.out.println("NO");
						return;
					} else if (stack.peek() == series[i]) {
						stack.pop();
						sb.append("-").append("\n");
						break;
					}
					stack.pop();
					sb.append("-").append("\n");
				}
			}
		}

		System.out.print(sb);

	}

}

package baekjoon.b1874;

import java.util.Scanner;
import java.util.Stack;

public class B1874 {

	private static Stack<Integer> stack = new Stack<>();
	private static int cnt = 0;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = input.nextInt();
		int[] series = new int[n];
		for (int i = 0; i < n; i++) {
			series[i] = input.nextInt();
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
						input.close();
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

		input.close();

	}

}

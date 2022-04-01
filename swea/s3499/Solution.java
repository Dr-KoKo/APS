package s3499;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int T = input.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = input.nextInt();
			input.nextLine();
			Queue<String> queue1 = new LinkedList<>();
			Queue<String> queue2 = new LinkedList<>();
			String[] str = input.nextLine().split(" ");
			for (int i = 0; i < (N + 1) / 2; i++) {
				queue1.add(str[i]);
			}
			for (int i = (N + 1) / 2; i < N; i++) {
				queue2.add(str[i]);
			}

			sb.append("#").append(tc);
			while (true) {
				if (!queue1.isEmpty())
					sb.append(" ").append(queue1.remove());
				if (!queue2.isEmpty())
					sb.append(" ").append(queue2.remove());
				if (queue1.isEmpty() && queue2.isEmpty())
					break;
			}

			System.out.println(sb);

			sb.setLength(0);

		}
	}
}

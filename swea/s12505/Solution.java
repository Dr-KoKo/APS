package s12505;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int T = input.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = input.nextInt();
			int M = input.nextInt();
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				queue.add(input.nextInt());
			}
			
			for (int t = 0; t < M; t++) {
				int temp = queue.remove();
				queue.add(temp);
			}

			System.out.printf("#%d %d\n", tc, queue.remove());

		}

	}
}

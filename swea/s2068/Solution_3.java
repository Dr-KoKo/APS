package s2068;

import java.util.PriorityQueue;
import java.util.Scanner;

// 2068.최대수 구하기
// PriorityQueue
public class Solution_3 {

	static Scanner input = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

			for (int j = 0; j < 10; j++) {

				pq.add(input.nextInt());

			}

			stringBuild(tc, pq.poll());

		}

		System.out.print(sb);

		input.close();

	}

	private static void stringBuild(int tc, int ans) {

		sb.append("#").append(tc).append(" ").append(ans).append("\n");

	}

}

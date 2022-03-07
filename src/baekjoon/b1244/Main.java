package baekjoon.b1244;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = input.nextInt();
		int[] switches = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			switches[i] = input.nextInt();
		}

		int T = input.nextInt();
		for (int t = 1; t <= T; t++) {
			int g = input.nextInt();
			int num = input.nextInt();

			switch (g) {
			case 1:
				for (int i = 1; i <= N; i++) {
					if (i % num == 0)
						switches[i] = turn(switches[i]);
				}
				break;
			case 2:
				int min = Math.min(num - 1, N - num);
				switches[num] = turn(switches[num]);
				for (int i = 1; i <= min; i++) {
					if (switches[num + i] == switches[num - i]) {
						switches[num + i] = turn(switches[num + i]);
						switches[num - i] = turn(switches[num - i]);
					} else
						break;
				}
				break;
			}

		}

		int cnt = 0;
		for (int i = 0; i < N / 20; i++) {
			for (int j = 1; j <= 20; j++) {
				sb.append(switches[cnt * 20 + j]).append(" ");
			}
			sb.append("\n");
			cnt++;
		}
		for (int j = 1; j <= N % 20; j++) {
			sb.append(switches[cnt * 20 + j]).append(" ");
		}

		System.out.println(sb.toString());

		input.close();

	}

	private static int turn(int num) {
		return 1 - num;
	}
}

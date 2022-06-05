package b4344;

import java.util.Scanner;

public class Main_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int C = input.nextInt();

		for (int c = 1; c <= C; c++) {

			int N = input.nextInt();

			int[] scores = new int[N];
			for (int i = 0; i < N; i++) {
				scores[i] = input.nextInt();
			}

			double avg = 0;
			for (int i = 0; i < N; i++) {
				avg += scores[i];
			}
			avg = avg / (double) N;

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (scores[i] > avg) {
					cnt++;
				}
			}

			double ans = (double) cnt / N;
			System.out.printf("%.3f%%\n", Math.round(ans * 1000*100) / 1000.0);

		}
	}
}

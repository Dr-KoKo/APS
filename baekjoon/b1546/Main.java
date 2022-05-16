package b1546;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();

		double ans = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			int temp = input.nextInt();

			ans += temp;

			if (max < temp) {
				max = temp;
			}
		}

		System.out.println(ans / max * 100 / N);

		input.close();

	}
}

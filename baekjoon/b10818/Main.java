package b10818;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			int temp = input.nextInt();

			if (temp > max) {
				max = temp;
			}

			if (temp < min) {
				min = temp;
			}
		}

		System.out.printf("%d %d", min, max);

		input.close();
	}
}

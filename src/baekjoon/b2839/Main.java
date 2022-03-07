package baekjoon.b2839;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		input.close();
		int bagFive = n / 5;
		int bagThree = 0;

		while (true) {
			if ((n - 5 * bagFive) % 3 == 0) {
				bagThree = (n - 5 * bagFive) / 3;
				break;
			}
			bagFive--;
			if (bagFive < 0) {
				break;
			}
		}

		System.out.println(bagFive + bagThree);

	}
}

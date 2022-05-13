package b2739;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();

		for (int i = 1; i < 10; i++) {
			System.out.printf("%d * %d = %d\n", N, i, N * i);
		}
	}
}

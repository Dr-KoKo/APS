package b11022;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int A = input.nextInt();
			int B = input.nextInt();
			System.out.printf("Case #%d: %d + %d = %d\n", tc, A, B, A + B);
		}
	}
}

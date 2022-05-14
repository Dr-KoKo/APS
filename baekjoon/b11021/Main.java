package b11021;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int AplusB = input.nextInt() + input.nextInt();
			System.out.printf("Case #%d: %d\n", tc, AplusB);
		}
	}
}

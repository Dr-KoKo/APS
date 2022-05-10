package b2525;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int A = input.nextInt();
		int B = input.nextInt();
		int C = input.nextInt();

		int x = A * 60 + B + C;

		if (x >= 24 * 60) {
			int _x = x - 24 * 60;
			System.out.printf("%d %d\n", _x / 60, _x % 60);
		} else {
			System.out.printf("%d %d\n", x / 60, x % 60);
		}

	}
}

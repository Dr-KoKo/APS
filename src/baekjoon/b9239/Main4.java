package baekjoon.b9239;

import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		int Xn = (int) (input.nextDouble() * 10000);
		int n = 0;
		for (int i = 1; i < 100000000; i++) {
			if (Xn * i % 10000 == 0) {
				Xn = Xn * i / 10000;
				n = i;
				break;
			}
		}

		boolean isNoSolution = true;
		for (int i = 1; i < 100000000 / Xn; i++) {
			sb1.append(Xn * i);
			sb2.append(n * i);

			outer: if (sb1.length() == sb2.length() && sb1.charAt(sb1.length() - 1) == sb2.charAt(0)) {
				for (int j = 0; j < sb1.length() - 1; j++) {
					if (sb1.charAt(j) != sb2.charAt(j + 1))
						break outer;
				}
				System.out.println(sb2);
				isNoSolution = false;
			}

			sb1.setLength(0);
			sb2.setLength(0);
		}

		if (isNoSolution)
			System.out.println("No solution");

	}

}
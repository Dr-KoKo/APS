package baekjoon.b9239;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

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
			
			
			
		}

		if (isNoSolution)
			System.out.println("No solution");

	}

}
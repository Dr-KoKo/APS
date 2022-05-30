package b1065;

import java.util.Scanner;

public class Main_2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int X = input.nextInt();

		int cnt = 0;

		for (int i = 1; i <= X; i++) {
			if (seq(i)) {
				cnt++;
			}
		}

		System.out.println(cnt);

	}

	private static boolean seq(int N) {

		if (N < 100) {
			return true;
		}

		int d1 = N / 100 - N / 10 % 10;
		int d2 = N / 10 % 10 - N % 10;

		if (d1 == d2) {
			return true;
		}

		return false;

	}

}

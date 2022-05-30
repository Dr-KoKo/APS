package b1065;

import java.util.Scanner;

public class Main_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int X = input.nextInt();

		int cnt = 0;

		for (int i = 1; i <= X; i++) {
			if(seq(String.valueOf(i))) {
				cnt++;
			}
		}

		System.out.println(cnt);

	}

	private static boolean seq(String N) {

		switch (N.length()) {
		case 1:
		case 2:
			return true;
		case 3:
			int d1 = N.charAt(0) - N.charAt(1);
			int d2 = N.charAt(1) - N.charAt(2);
			if (d1 == d2) {
				return true;
			}
		default:
			return false;
		}

	}

}

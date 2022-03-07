package baekjoon.b1002;

import java.util.Scanner;

public class B1002 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int x1 = input.nextInt();
			int y1 = input.nextInt();
			int r1 = input.nextInt();
			int x2 = input.nextInt();
			int y2 = input.nextInt();
			int r2 = input.nextInt();

			if (r1 <= r2)
				System.out.println(cal(x1, y1, r1, x2, y2, r2));
			else if (r1 > r2)
				System.out.println(cal(x2, y2, r2, x1, y1, r1));

		}

		input.close();

	}

	private static int cal(int x1, int y1, int r1, int x2, int y2, int r2) { // r1 <= r2
		int dsq = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);

		if (x1 == x2 && y1 == y2) {
			if (r1 == r2)
				return -1;
			else
				return 0;
		}

		if (dsq < r2 * r2) {
			if (dsq < (r2 - r1) * (r2 - r1))
				return 0;
			else if (dsq == (r2 - r1) * (r2 - r1))
				return 1;
			else if (dsq > (r2 - r1) * (r2 - r1))
				return 2;
		} else if (dsq == r2 * r2) {
			return 2;
		} else if (dsq > r2 * r2) {
			if (dsq < (r1 + r2) * (r1 + r2))
				return 2;
			else if (dsq == (r1 + r2) * (r1 + r2))
				return 1;
			else if (dsq > (r1 + r2) * (r1 + r2))
				return 0;
		}

		System.out.println("계산오류가 발생했습니다.");
		return 0;
	}
}

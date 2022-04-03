package b10250;

import java.util.Scanner;

public class B10250 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int H = input.nextInt();
			int W = input.nextInt();
			int N = input.nextInt();

			System.out.printf("%d%02d\n", N % H == 0 ? H : N % H, N % H == 0 ? N / H : N / H + 1);

		}

		input.close();

	}

}

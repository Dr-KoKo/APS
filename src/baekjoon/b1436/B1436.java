package baekjoon.b1436;

import java.util.Scanner;

public class B1436 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();
		int cnt = 0;
		int movieName = -1;

		for (int i = 1;; i++) {
			if (Integer.toString(i).contains("666")) {
				cnt++;
				if (cnt == N) {
					movieName = i;
					break;
				}
			}
		}

		System.out.println(movieName);

		input.close();

	}
}

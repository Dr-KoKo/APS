package swea.s1940;

import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int T = input.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = input.nextInt();
			int D = 0;
			int V = 0;

			for (int n = 0; n < N; n++) {
				int command = input.nextInt();
				switch (command) {
				case 0:
					D += V;
					break;
				case 1:
					V += input.nextInt();
					D += V;
					break;
				case 2:
					V -= input.nextInt();
					if (V < 0)
						V = 0;
					D += V;
					break;
				}
			}

			System.out.printf("#%d %d\n", tc, D);
		}
	}

}

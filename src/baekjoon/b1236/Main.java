package baekjoon.b1236;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int m = input.nextInt();
		int n = input.nextInt();

		char[][] castle = new char[m][n];

		for (int i = 0; i < m;) {
			String str = input.next();
			if (str.length() == n) {
				castle[i] = str.toCharArray();
				i++;
			}
		}

		input.close();
		
		cal(m, n, castle);

	}

	public static void cal(int m, int n, char[][] cas) {
		int cntc = 0;
		int cntr = 0;

		outer: for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (cas[i][j] == 'X')
					continue outer;
			}
			cntc++;
		}

		outer: for (int j = 0; j < n; j++) {
			for (int i = 0; i < m; i++) {
				if (cas[i][j] == 'X')
					continue outer;
			}
			cntr++;
		}

		System.out.println(Math.max(cntc, cntr));
	}
}

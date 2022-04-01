package s1926;

import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);
	private static int N;

	public static void main(String[] args) {
		N = input.nextInt();

		for (int i = 1; i <= N; i++) {
			int cnt = cal(i);
			if (cnt == 0)
				System.out.printf("%d ", i);
			else {
				for (int j = 0; j < cnt; j++) {
					System.out.print('-');
				}
				System.out.print(' ');
			}
		}

	}

	private static int cal(int n) {
		int cnt = 0;
		if (n % 10 == 3 || n % 10 == 6 || n % 10 == 9)
			cnt++;
		if (n / 10 == 3 || n / 10 == 6 || n / 10 == 9)
			cnt++;
		return cnt;
	}
}
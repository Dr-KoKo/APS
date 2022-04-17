package swea.s1289;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			char temp = '0';
			int cnt = 0;
			for (char c : input.next().toCharArray()) {
				if (c != temp) {
					temp = c;
					cnt++;
				}
			}

			System.out.printf("#%d %d\n", tc, cnt);
		}

		input.close();

	}
}

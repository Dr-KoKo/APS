package b8958;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int cnt = 0;
			int ans = 0;

			for (char ch : input.next().toCharArray()) {
				switch (ch) {
				case 'O':
					ans += (++cnt);
					break;
				case 'X':
					cnt = 0;
					break;
				}
			}

			System.out.println(ans);
			
		}

		input.close();
		
	}
}

package b5622;

import java.util.Scanner;

public class Main_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int ans = 0;

		for (char ch : input.next().toCharArray()) {
			if (ch >= 'A' && ch <= 'O') {
				int num = 3 + (ch - 'A') / 3;
				ans += num;
			} else if (ch >= 'P' && ch <= 'S') {
				ans += 8;
			} else if(ch>='T' && ch<='V') {
				ans += 9;
			} else if(ch<='W'&&ch<='Z') {
				ans += 10;
			}
		}
		
		System.out.println(ans);

	}
}

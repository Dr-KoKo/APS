package b2884;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int H = input.nextInt();
		int M = input.nextInt();

		int x = H * 60 + M - 45;

		if (x < 0) {
			int _x = 60 * 24 + x;
			System.out.println(_x/60);
			System.out.println(_x%60);
		} else {
			System.out.println(x/60);
			System.out.println(x%60);
		}
			
	}
}

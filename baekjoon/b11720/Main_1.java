package b11720;

import java.util.Scanner;

public class Main_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		input.next();
		char[] nums = input.next().toCharArray();

		int ans = 0;
		for (char c : nums) {
			ans += c - '0';
		}
		
		System.out.println(ans);

	}
}

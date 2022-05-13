package b8393;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		
		int ans = 0;
		
		for (int i = 1; i <= n; i++) {
			ans += i;
		}
		
		System.out.println(ans);
	}
}

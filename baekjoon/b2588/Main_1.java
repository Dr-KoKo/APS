package b2588;

import java.util.Scanner;

public class Main_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int A = input.nextInt();
		int B = input.nextInt();

		int ans = 0;

		int cnt = 0;
		while (B / 10 != 0 || B % 10 != 0) {
			int temp = A * (B % 10);
			System.out.println(temp);
			
			for (int i = 0; i < cnt; i++) {
				temp *= 10;
			}
			
			ans += temp;

			B /= 10;
			cnt++;
		}
		
		System.out.println(ans);
	}
}

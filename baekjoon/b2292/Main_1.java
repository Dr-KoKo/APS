package b2292;

import java.util.Scanner;

public class Main_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();

		int cnt = 1;
		int max = 1;

		while (N > max) {
			max += 6 * (cnt++);
		}

		System.out.println(cnt);
	}
}

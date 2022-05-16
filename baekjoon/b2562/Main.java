package b2562;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int max = Integer.MIN_VALUE;
		int maxIdx = -1;

		for (int i = 1; i < 10; i++) {
			int temp = input.nextInt();

			if (temp > max) {
				max = temp;
				maxIdx = i;
			}
		}
		
		System.out.println(max);
		System.out.println(maxIdx);
		
		input.close();
		
	}
}

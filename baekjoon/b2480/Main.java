package b2480;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int[] count = new int[6 + 1];

		for (int i = 1; i <= 3; i++) {
			count[input.nextInt()]++;
		}

		int max = Integer.MIN_VALUE;
		int dice = 0;

		for (int i = 1; i <= 6; i++) {
			if (max <= count[i]) {
				max = count[i];
				dice = i;
			}
		}

		switch (max) {
		case 1:
			System.out.println(dice * 100);
			break;
		case 2:
			System.out.println(1000 + dice * 100);
			break;
		case 3:
			System.out.println(10000 + dice * 1000);
			break;
		}

	}
}

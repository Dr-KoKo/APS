package swea.s1860;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);
	private static int N;
	private static int M, K;
	private static int[] guests;

	public static void main(String[] args) {
		int T = input.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = input.nextInt();
			M = input.nextInt();
			K = input.nextInt();
			input.nextLine();
			guests = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int i = guests.length - 1; i >= 0; i--)
				for (int j = 0; j < i; j++)
					if (guests[j + 1] < guests[j]) {
						int temp = guests[j];
						guests[j] = guests[j + 1];
						guests[j + 1] = temp;
					}
			
			System.out.printf("#%d ", tc);
			check();
		}
	}

	private static void check() {
		for (int i = 0; i < guests.length; i++) {
			int stock = guests[i] / M * K;
			int guestNum = i+1;
			if (guestNum > stock) {
				System.out.println("Impossible");
				return;
			}
		}

		System.out.println("Possible");
		return;
	}

}

package b3052;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int[] count = new int[42];
		int cnt = 0; 

		for (int i = 0; i < 10; i++) {
			int temp = input.nextInt();

			count[temp % 42]++;
		}

		for (int i : count) {
			if(i!=0) {
				cnt++;
			}
		}

		System.out.println(cnt);

	}
}

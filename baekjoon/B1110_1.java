package baekjoon;

import java.util.Scanner;

public class B1110_1 {
	private static int cnt = 0;
	private static int inputInt;

	public static void main(String[] args) {
		input();
		cycle(inputInt);
		print();
	}

	private static void print() {
		System.out.println(cnt);
	}

	private static void input() {
		Scanner input = new Scanner(System.in);

		inputInt = input.nextInt();

		input.close();
	}

	private static void cycle(int n) {
		int fd = n / 10;
		int sd = n % 10;

		int nfd = (fd + sd) / 10; // (fd+sd) = n-9*fd
		int nsd = (fd + sd) % 10;

		int temp = sd * 10 + nsd;
		if (temp == inputInt) {
			++cnt;
		} else {
			++cnt;
			cycle(temp);
		}
	}
}

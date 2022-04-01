package b1110;

import java.util.Scanner;

public class Main {
	static int cnt = 0;
	static int inputInt;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		inputInt = input.nextInt();
		input.close();
		if (inputInt < 10) {
			inputInt *= 10;
		}

		System.out.println(cycle(inputInt));
	}

	public static int cycle(int n) {
		int fd = n / 10;
		int sd = n % 10;

		int nfd = (fd + sd) / 10; // (fd+sd) = n-9*fd
		int nsd = (fd + sd) % 10;

		int temp = sd * 10 + nsd;
		if (temp == inputInt) {
			return ++cnt;
		} else {
			++cnt;
			return cycle(temp);
		}
	}
}

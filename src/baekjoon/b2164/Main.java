package baekjoon.b2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int N = input.nextInt();
		Queue<Integer> cards = new LinkedList<>();
		for (int n = 1; n <= N; n++) {
			cards.add(n);
		}

		while (true) {
			int temp = cards.remove();
			if (cards.isEmpty()) {
				System.out.println(temp);
				break;
			} else {
				temp = cards.remove();
				cards.add(temp);
			}
		}

	}
}

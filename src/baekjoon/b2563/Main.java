package baekjoon.b2563;

import java.util.Scanner;

public class Main {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] arr = new int[100][100];
		int sum = 0;

		int T = input.nextInt();

		for (int t = 0; t < T; t++) {
			int x = input.nextInt();
			int y = input.nextInt();
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					arr[y + i][x + j] = 1;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
			}
		}

		System.out.println(sum);
	}
}

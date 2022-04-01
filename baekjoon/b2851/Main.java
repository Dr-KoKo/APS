package b2851;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner inputInt = new Scanner(System.in);

		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = inputInt.nextInt();
		}
		inputInt.close();

		System.out.println(hund(arr));

	}

	public static int hund(int[] arr) {
		int sum = 0;
		int sumTemp = 0;
		for (int i = 0; i < arr.length; i++) {
			sumTemp += arr[i];
			if (sumTemp >= 100)
				return (Math.abs(sumTemp - 100) > Math.abs(sum - 100)) ? sum : sumTemp;
			sum += arr[i];
		}
		return sumTemp;
	}
}

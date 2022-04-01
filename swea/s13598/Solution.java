package s13598;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int[] arrI = new int[n];
		for (int i = 0; i < n; i++) {
			arrI[i] = input.nextInt();
		}

		int[] arrO = new int[n];
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			for (int j = i + 1; j < n; j++)
				if (arrI[i] <= arrI[j])
					cnt++;
			arrO[i] = n - 1 - i - cnt;
		}

		int temp = 0;
		for (int i = 0; i < n; i++)
			if (temp < arrO[i])
				temp = arrO[i];

		System.out.println(temp);
	}
}

package b1330;

import java.util.Scanner;

public class Solution_1 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int A = input.nextInt();
		int B = input.nextInt();

		System.out.println(A > B ? ">" : A == B ? "==" : "<");

	}

}

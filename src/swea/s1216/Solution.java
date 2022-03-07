package swea.s1216;

import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);
	private static int T;

	public static void main(String[] args) {
		T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int t = input.nextInt();
			char[][] arr = new char[100][100];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = input.nextLine().toCharArray();
			}
			
			calPal();
		}
		
	
	}

	private static int cal(char[][] chArr) {
		int N = 100;
		
	}

	private static boolean calPal(char[] chArr) {
		StringBuilder sb = new StringBuilder();
		char[] chRev = sb.append(chArr).reverse().toString().toCharArray();

		boolean isPal = true;
		for (int i = 0; i < chRev.length / 2; i++) {
			if (chArr[i] != chRev[i]) {
				isPal = false;
				break;
			}
		}

		return isPal;
	}
}

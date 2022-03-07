package swea.s1215;

import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);
	private static int T;

	public static void main(String[] args) {
		T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int n = input.nextInt();
			input.nextLine();

			char[][] arr = new char[8][8];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = input.nextLine().toCharArray();
			}
			System.out.printf("#%d %d\n", tc, cal(arr,n));

		}
	}
	
	private static int cal(char[][] arr, int n) {
		int cnt = 0;
		
		for (int i = 0; i < arr.length; i++) 
			for (int j = 0; j <= arr[i].length-n; j++) {
				char[] tempR = new char[n];
				char[] tempC = new char[n];
				for (int j2 = 0; j2 < n; j2++) {
					tempR[j2] = arr[i][j2+j];
					tempC[j2] = arr[j2+j][i];
				}
				cnt += pal(tempR)? 1:0;
				cnt += pal(tempC)? 1:0;
			}
		
		return cnt;
	}
	
	private static boolean pal(char[] chArr) {
		boolean isPal = true;
		for (int i = 0; i < chArr.length/2; i++) 
			if(chArr[i]!=chArr[chArr.length-1-i]) {
				isPal = false;
				return isPal;
			}
		
		return isPal;
	}
}

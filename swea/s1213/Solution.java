package s1213;

import java.util.Scanner;

public class Solution {
//	스캐너 생성
	public static Scanner input = new Scanner(System.in);
//	Testcase
	private static int T;

	public static void main(String[] args) {
//		Testcase 수
		T = 10;
//		Test 실행
		for (int tc = 1; tc <= T; tc++) {
			String t = input.nextLine(); // 불필요 input
			char[] pArr = input.nextLine().toCharArray(); // pattern input
			char[] tArr = input.nextLine().toCharArray(); // text input

			System.out.printf("#%d %d\n", tc, cal(pArr, tArr)); // 실행 및 출력
		}
	}

//	cal 메서드 : Brute Force
	public static int cal(char[] p, char[] t) {
		int i = 0;
		int j = 0;

		int cnt = 0;
		while (i < t.length) {
			if (t[i] != p[j]) {
				i = i - j;
				j = -1;
			}
			if (j == p.length-1) { // pattern발견시 1. cnt++ 2. 탐색 재개
				cnt++;
				i = i - j;
				j = -1;
			}
			i++;
			j++;
		}
		
		return cnt;
	}
}

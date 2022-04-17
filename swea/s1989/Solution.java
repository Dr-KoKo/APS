package swea.s1989;

import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);
	private static int T;

	public static void main(String[] args) {
		T = input.nextInt();
		input.nextLine();

		for (int tc = 1; tc <= T; tc++) {
			String strIn = input.nextLine();
			System.out.printf("#%d %d\n", tc, cal(strIn));
		}
	}

//	방법1 : 새로운 빈 문자열을 만들어 뒤에서부터 읽는 방법
//	private static int cal(String str) {
//		String strOut = "";
//		for (int i = str.length() - 1; i >= 0; i--) {
//			strOut += str.charAt(i);
//		}
//		if (str.equals(strOut))
//			return 1;
//		return 0;
//	}

//	방법2 : swap
	private static int cal(String str) {
		char[] chArrI = str.toCharArray();
		char[] chArr = str.toCharArray();
		for (int i = 0; i < (str.length()+1)/2; i++) {
			char temp = chArr[i];
			chArr[i] = chArr[str.length()-1-i];
			chArr[str.length()-1-i] = temp;
		}
		for (int i = 0; i < chArr.length; i++) {
			if (chArr[i] != chArrI[i])
				return 0;
		}
		return 1;
	}

//	방법3 : reverse
//	private static int cal(String str) {
//		StringBuffer sb = new StringBuffer();
//		for (int i = str.length()-1; i >=0 ; i--) {
//			sb.append(str.charAt(i));
//		}
//		if (str.equals(sb.toString())) 
//			return 1;
//		return 0;
//	}

//	방법4:회문확인
//	private static int cal(String str) {
//		int p1 = 0;
//		int p2 = str.length() - 1;
//
//		while (p1 < p2) {
//			if (str.charAt(p1) != str.charAt(p2))
//				return 0;
//			p1++;
//			p2--;
//		}
//		return 1;
//	}
}

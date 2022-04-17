package swea.s13636;

import java.util.Scanner;

public class Solution {
	static Scanner input = new Scanner(System.in);
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = input.nextInt();
			input.nextLine();

			char[] series = input.nextLine().toCharArray();

			sb.append("#").append(tc).append(" ").append(cal(series)).append("\n");
		}

		System.out.print(sb);
		
	}

	public static int cal(char[] target) {
		int result = 0;
		int cnt = 0;

		for (char c : target) {
			if (c == '1')
				result = Math.max(result, ++cnt);
			else if (c == '0') {
				cnt = 0;
			}
		}
		return result;
	}
}

package b2675;

import java.util.Scanner;

public class Main_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = input.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = input.nextInt();
			String str = input.next();
			
			for (int i = 0; i < str.length(); i++) {
				for (int n = 0; n < N; n++) {
					sb.append(str.charAt(i));
				}
			}
		
			System.out.println(sb);
			
			sb.setLength(0);
		}
	}
}

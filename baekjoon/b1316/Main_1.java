package b1316;

import java.util.Scanner;

public class Main_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int ans = 0;
		
		int N = input.nextInt();
		
		test: for (int n = 0; n < N; n++) {

			boolean[] check = new boolean[26];

			char[] charArr = input.next().toCharArray();

			char bef = '\n';

			for (char c : charArr) {
				if (bef != c) {
					if (check[c - 'a']) {
						continue test;
					}
					check[c - 'a'] = true;
					bef = c;
				}
			}
			
			ans++;
			
		}
		
		System.out.println(ans);
	}
}

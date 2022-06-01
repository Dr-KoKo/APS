package b1157;

import java.util.Scanner;

public class Main_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		char[] str = input.next().toLowerCase().toCharArray();
		
		int[] cnt = new int[30];
		for (char ch : str) {
			cnt[ch-'a']++;
		}
		
		int max = Integer.MIN_VALUE;
		char ans = '?';
		for (int i = 0; i < cnt.length; i++) {
			if(cnt[i]>max) {
				max = cnt[i];
				ans = (char) (i+'A');
			} else if(cnt[i]==max) {
				ans = '?';
			}
		}

		System.out.println(ans);
		
	}
}


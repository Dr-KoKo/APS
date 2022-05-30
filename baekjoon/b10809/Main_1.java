package b10809;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int[] idx = new int[26];
		Arrays.fill(idx, -1);
		
		char[] chs = input.next().toCharArray();
		
		for (int i = chs.length-1; i >= 0; i--) {
			idx[chs[i]-'a'] = i; 
		}
		
		for (int i : idx) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb);
	}
}

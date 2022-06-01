package b5622;

import java.util.Scanner;

public class Main_2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		char[] phoneNumber = input.next().toCharArray();
		
		int[] dial = {3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10};
		
		int ans = 0;
		
		for (char c : phoneNumber) {
			ans += dial[c-'A'];
		}
		
		System.out.println(ans);
	}
}

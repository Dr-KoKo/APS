package baekjoon.b1152;

import java.util.Scanner;

public class B1152 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String[] str = input.nextLine().split(" ");
		
		int cnt = 0;
		for (int i = 0; i < str.length; i++) {
			if(!str[i].equals("")) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
}

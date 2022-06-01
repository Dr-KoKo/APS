package b2908;

import java.util.Scanner;

public class Main_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a = Integer.parseInt(new StringBuilder(input.next()).reverse().toString());
		int b = Integer.parseInt(new StringBuilder(input.next()).reverse().toString());

		if(a>b) {
			System.out.println(a);
		} else {
			System.out.println(b);
		}

	}
}

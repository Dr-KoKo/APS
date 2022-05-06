package b2577;

import java.util.Scanner;

public class Main_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int[] count = new int[10];
		
		int x = input.nextInt() * input.nextInt() * input.nextInt();
		
		String str = String.valueOf(x);
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i) - '0']++;
		}
		
		for (int i = 0; i < count.length; i++) {
			System.out.println(count[i]);
		}
		
		input.close();
	}
}

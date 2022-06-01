package b2908;

import java.util.Scanner;

public class Main_2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		char[] char_A = input.next().toCharArray();
		char[] charA = new char[char_A.length];
		for (int i = 0; i < charA.length; i++) {
			charA[i] = char_A[char_A.length-1-i];
		}
		
		char[] char_B = input.next().toCharArray();
		char[] charB = new char[char_B.length];
		for (int i = 0; i < charB.length; i++) {
			charB[i] = char_B[char_B.length-1-i];
		}
		
		int A = Integer.parseInt(new String(charA));
		int B = Integer.parseInt(new String(charB));
		
		if(A>B) {
			System.out.println(A);
		} else {
			System.out.println(B);
		}
		
	}
}

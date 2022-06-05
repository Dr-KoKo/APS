package b1712;

import java.util.Scanner;

public class Main_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		long A = input.nextLong(); // 고정비용
		long B = input.nextLong(); // 가변비용
		long C = input.nextLong(); // 판매비용

//		A + B*x < C*x
//		A < (C-B)*x

		if (C - B <= 0) {
			System.out.println(-1);
		} else {
			System.out.println(A / (C - B) + 1);
		}
	}
}

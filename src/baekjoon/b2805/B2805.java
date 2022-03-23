package baekjoon.b2805;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long M = sc.nextLong();
		long H;
		long sum;

		long[] arr = new long[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		outer: for (long i = 0;; i++) {
			sum = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] > i)
					sum += (arr[j] - i);
			}
			if (sum < M) {
				H = i - 1;
				break outer;
			}
		}

//		while(true) {
//			
//		}
		
		System.out.println(H);

	}
}

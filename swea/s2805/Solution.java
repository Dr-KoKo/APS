package s2805;

import java.util.Scanner;

public class Solution {
//	스캐너 선언
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
//		Testcase 수 입력
		int T = input.nextInt();
		int[] output = new int[T + 1];
//		Test 실행
		for (int tc = 1; tc <= T; tc++) {
			// 농장 크기 입력
			int N = input.nextInt();
			input.nextLine();

			// 계산 준비 전 필드 선언
			int sum = 0;
			int idxMid = (N - 1) / 2;

			// 중간 전
			for (int i = 0; i < idxMid; i++) {
				String str = input.nextLine();
				for (int j = -i; j <= i; j++) {
					sum += str.charAt(idxMid + j) - '0';
				}
			}
			// 중간 후
			for (int i = idxMid; i < N; i++) {
				String str = input.nextLine();
				for (int j = -(N - 1 - i); j <= (N - 1 - i); j++) {
					sum += str.charAt(idxMid + j) - '0';
				}
			}

			// 결과 입력
			output[tc] = sum;
		}

//		결과 출력
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d\n", tc, output[tc]);
		}
	}
}

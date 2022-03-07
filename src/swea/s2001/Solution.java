package swea.s2001;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
//	스캐너 선언
	public static Scanner input = new Scanner(System.in);
//	필드 선언
	private static int[][] fly;
	private static int N, M;

	public static void main(String[] args) {
//		Test case 수
		int T = input.nextInt();
		int[] output = new int[T + 1];
//		Test 실행
		for (int tc = 1; tc <= T; tc++) {
			N = input.nextInt(); // 배열 크기
			fly = new int[N][N];
			M = input.nextInt(); // 파리채 크기
			input.nextLine();
			for (int i = 0; i < arr.length; i++) { // 배열 값 입력
				arr[i] = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			output[tc] = hitMax(); // 결과값 입력
		}

//		결과 출력
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d\n", tc, output[tc]);
		}
	}

//	hitMax 메서드 : 최대 파리수 반환
	private static int hitMax() {
		int ret = 0;
		int sum;
		for (int i = 0; i <= N - M; i++) {
			for (int j = 0; j <= N - M; j++) {
				sum = 0;
				for (int k = 0; k < M; k++)
					for (int k2 = 0; k2 < M; k2++)
						sum += arr[i + k][j + k2];
				ret = Math.max(ret, sum);
			}
		}
		return ret;
	}
}

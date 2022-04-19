package s5215;

import java.util.Scanner;

public class Solution {
//	스캐너 선언
	public static Scanner input = new Scanner(System.in);
	
//	private static Map<Integer,int[]> map = new HashMap<>();
	
//	필드 선언
	private static int N, L;
	private static int score;
	private static int[][] data;
	

	public static void main(String[] args) {
//		Testcase 선언
		int T = input.nextInt();
//		Test 실행
		for (int tc = 1; tc <= T; tc++) {
			// 재료 수 입력(초기화/재할당)
			N = input.nextInt();
			// 최대 칼로리 값 입력(초기화/재할당)
			L = input.nextInt();
			// 재료 정보(점수, 칼로리) 입력(초기화/재할당)
			data = new int[N][2];
			for (int i = 0; i < N; i++) {
				data[i][0] = input.nextInt();
				data[i][1] = input.nextInt();
			}

			// 계산
			score = 0; // 점수 초기화 : score변수가 전역변수이므로 초기화 필요
			cal(0, 0, 0); // 계산
			
			// 결과 출력
			System.out.printf("#%d %d\n", tc, score);

		}
	}

//	cal 메서드 : 반환값 X. 전역변수 score를 최고 점수로 바꾸는 메서드. 
	private static void cal(int idx, int sumScore, int sumCalorie) {
		if (idx == N) {
			if (sumCalorie <= L) {
				score = Math.max(score, sumScore);
				return;
			}
			return;
		}

		cal(idx + 1, sumScore, sumCalorie);
		cal(idx + 1, sumScore + data[idx][0], sumCalorie + data[idx][1]);

	}

}

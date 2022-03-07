package swea.s1288;

import java.util.Scanner;

public class Solution {
//	Scanner 생성
	public static Scanner input = new Scanner(System.in);
//	Flag 생성
	private static boolean[] isSel;

	public static void main(String[] args) {
		// 총 Testcase 수 입력 
		int T = input.nextInt();
		// Test 실행
		for (int tc = 1; tc <= T; tc++) {
			// 첫 번째 양 입력
			int N = input.nextInt();
			// count 메서드 실행 및 출력
			System.out.printf("#%d %d\n", tc, count(N));

		}

	}

//	count 메서드 : 0~9의 모든 숫자를 보는 최소의 횟수
	private static int count(int n) {
		int sub = 0; // 독립 변수
		isSel = new boolean[10]; // Flag 초기화

		while (true) {
			sub += n; // n의 배수를 차례로 대입
			// 1. sub의 값을 char형으로 parsing
			// 2. sub의 숫자에 대응되는 Flag의 index -> true  
			String str = String.valueOf(sub);
			for (int i = 0; i < str.length(); i++) {
				if (!isSel[str.charAt(i)-'0'])
					isSel[str.charAt(i)-'0'] = true;
				boolean isDone = true;
				for (int j = 0; j < isSel.length; j++) {
					if(!isSel[j])
						isDone=false;
				}
				if(isDone)
					return sub;
			}
		}
	}
}

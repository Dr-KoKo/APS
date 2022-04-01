package s2068;

import java.util.Scanner;

public class Solution {
//	temp 변수 생성
//	1. 변수(또는 메서드)가 static인 main메서드에서 실행되기 위해서는 static으로 선언되어야함.
//	2. 외부 클래스에서 참조하면 곤란하므로 private로 선언
	private static int temp;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

//		테스트 케이스 수 입력
		int T = input.nextInt(); input.nextLine();
		
//		테스트 케이스 실행
		for (int i = 0; i < T; i++) {
			temp = 0; // temp 초기화
			for (int j = 0; j < 10; j++) { // 최대값을 temp에 저장
				temp = Math.max(temp, input.nextInt());
			}
			input.nextLine();

			System.out.printf("#%d ", i + 1); // 결과 출력
			System.out.println(temp);
		}
		
		input.close();

	}
}

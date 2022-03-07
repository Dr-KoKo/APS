package swea.s2071;

import java.util.Scanner;

public class Solution {
//	Scanner 인스턴스 생성
//	1. 변수(또는 메서드)가 static인 main메서드에서 실행되기 위해서는 static으로 선언되어야함.
//	2. 외부 클래스에서 참조하면 곤란하므로 private로 선언
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
//		테스트 케이스 수 입력
		int T = input.nextInt();

//		테스트 케이스 실행
		for (int i = 0; i < T; i++) {
			System.out.printf("#%d %d", i + 1, Math.round(avg(10))); // avg(10)의 반환값을 소수점 첫째자리에서 반올림한 값(정수)을 출력
			System.out.println();
		}

		input.close();
		
	}

//	avg 메서드 : (argument)개의 정수를 입력받아 그 평균을 double형으로 반환 
	public static double avg(int n) {
		return ((double) sum(n)) / n;
	}

//	sum 메서드 : (argument)개의 정수를 입력받아 그 합을 int형으로 반환
	public static int sum(int n) {
		int s = 0;
		for (int i = 0; i < n; i++) {
			s += input.nextInt();
		}
		return s;
	}
}

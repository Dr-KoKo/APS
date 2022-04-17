package swea.s1974;

import java.util.Scanner;

public class Solution {
//	스캐너 선언
	public static Scanner input = new Scanner(System.in);
//	checkBox 선언
	private static boolean[] checkBoxRow;
	private static boolean[] checkBoxCol;
	private static boolean[] checkBox;

	public static void main(String[] args) {
//		Testcase 수 입력
		int T = input.nextInt();
		input.nextLine();

//		Test 실행
		for (int tc = 1; tc <= T; tc++) {
			// 스도쿠 데이터 저장
			int[][] arr = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					arr[i][j] = input.nextInt();
				}
			}
			// 결과 출력
			System.out.printf("#%d %d\n", tc, check(arr));
		}
	}

//	check 메서드 : 0 or 1 반환
	private static int check(int[][] target) {
		// 가로, 세로 확인
		for (int i = 0; i < 9; i++) {
			checkBoxRow = new boolean[10];
			checkBoxCol = new boolean[10];
			for (int j = 0; j < 9; j++) {
				if (checkBoxRow[target[i][j]])
					return 0;
				if (checkBoxCol[target[j][i]])
					return 0;
				checkBoxRow[target[i][j]] = true;
				checkBoxCol[target[j][i]] = true;
			}
		}

		// 칸 확인
		for (int i = 0; i < 3; i++) // 좌표값 설정
			for (int j = 0; j < 3; j++) {
				checkBox = new boolean[10];
				for (int k = 0; k < 3; k++) // 3 * 3 칸 만들기
					for (int k2 = 0; k2 < 3; k2++) {
						if (checkBox[target[3 * i + k][3 * j + k2]])
							return 0;
						checkBox[target[3 * i + k][3 * j + k2]] = true;
					}
			}

		return 1;
	}
}

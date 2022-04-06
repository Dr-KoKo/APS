package s1868;

import java.util.Scanner;

public class S1868 {

	private static char[][] board;
	private static int N;

	private static int[][] drc = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
			{ 1, 1 } };

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int T = input.nextInt();
		input.nextLine();

		for (int tc = 1; tc <= T; tc++) {

			N = input.nextInt();
			input.nextLine();

			board = new char[N][N];

			for (int i = 0; i < N; i++) {

				board[i] = input.nextLine().toCharArray();

			}
			
			// 1. * 옆에 있는 .를 모두 찾아서 체크
			// 2. 체크된 .의 팔방에 체크가 안된 .가 있다 -> 그 놈을 클릭하면 같이 눌릴 놈
			// 3. 체크된 .의 팔방에 체크가 안된 .가 없다 -> 사용자가 직접 눌러줘야 할 놈
			cal(); 

		}

		input.close();

	}

	private static void cal() {
		
	}





}

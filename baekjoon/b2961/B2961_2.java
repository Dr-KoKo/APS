package b2961;

import java.util.Scanner;

public class B2961_2 {

	private static int N;
	private static int[][] data;
	private static int ans;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// 1. 입력
		N = input.nextInt();

		data = new int[N][2];

		for (int i = 0; i < N; i++) {

			data[i][0] = input.nextInt(); // 신맛
			data[i][1] = input.nextInt(); // 쓴맛

		}

		// 2. 계산 및 결과 출력
		comb();

		input.close();

	}

	/**
	 * 1.초기화 2.계산 3.출력
	 * 
	 * @param N : 데이터의 크기
	 */
	private static void comb() {
		// 초기화
		ans = Integer.MAX_VALUE;

		// 계산
		combUtil(0, 1, 0);

		// 결과 출력
		System.out.println(ans);

	}

	/**
	 * 
	 * @param idx : base-case를 위한 param
	 */
	private static void combUtil(int idx, int s, int b) {

		if (idx == N) {

			if (b == 0)
				return;

			ans = Math.min(ans, Math.abs(s - b));

			return;

		}

		combUtil(idx + 1, s, b);
		combUtil(idx + 1, s * data[idx][0], b + data[idx][1]);

	}

}

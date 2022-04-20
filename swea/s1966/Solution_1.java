package s1966;

import java.util.Scanner;

// 1966.숫자를 정렬하자
// bubble_sort
public class Solution_1 {

	static Scanner input = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 1.입력
			int N = input.nextInt();

			int[] arr = inputToarr(N);

			// 2.계산(정렬)
			// 2-1.bubble_sort
			bubble_sort(arr, N);

			// 3.출력
			// 3-1.출력 준비
			stringBuild(tc, arr);

		}
		// 3-2.출력
		System.out.print(sb);

		input.close();

	}

	private static int[] inputToarr(int N) {

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {

			arr[i] = input.nextInt();

		}

		return arr;
	}

	private static void bubble_sort(int[] arr, int N) {

		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {

				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}
		}

	}

	private static void stringBuild(int tc, int[] arr) {

		sb.append("#").append(tc);

		for (int i : arr) {
			sb.append(" ").append(i);
		}

		sb.append("\n");

	}

}

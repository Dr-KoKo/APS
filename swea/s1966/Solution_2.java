package swea.s1966;

import java.util.Scanner;

// 1966.숫자를 정렬하자
// selection_sort
public class Solution_2 {

	static Scanner input = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 1.입력
			int N = input.nextInt();

			int[] arr = inputToarr(N);

			// 2.계산(정렬)
			// 2-2.selection_sort
			selection_sort(arr, N);

			// 3.출력
			// 3-1.출력 준비
			stringBuild(tc, arr);

		}
		// 3-2.출력
		System.out.print(sb);

		input.close();

	}

	private static void selection_sort(int[] arr, int N) {

		for (int i = 0; i < N - 1; i++) {
			int minIdx = i;

			for (int j = i + 1; j < N; j++) {
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}

			swap(arr, i, minIdx);
		}

	}

	private static int[] inputToarr(int N) {

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {

			arr[i] = input.nextInt();

		}

		return arr;
	}

	private static void swap(int[] arr, int i, int minIdx) {

		int temp = arr[i];
		arr[i] = arr[minIdx];
		arr[minIdx] = temp;

	}

	private static void stringBuild(int tc, int[] arr) {

		sb.append("#").append(tc);

		for (int i : arr) {
			sb.append(" ").append(i);
		}

		sb.append("\n");

	}

}

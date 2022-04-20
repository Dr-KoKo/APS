package s1966;

import java.util.Scanner;

// 1966.숫자를 정렬하자
// merge_sort
public class Solution_4 {

	static Scanner input = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = input.nextInt();

			int[] arr = inputToarr(N);

			mergeSort(arr, 0, N - 1);

			stringBuild(tc, arr);

		}

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

	private static void mergeSort(int[] arr, int left, int right) {

		if (left < right) {

			int mid = (left + right) / 2;

			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);

		}

	}

	private static void merge(int[] arr, int left, int mid, int right) {

		int L = left;
		int R = mid + 1;
		int idx = 0;

		int[] sortedArr = new int[right - left + 1];

		while (L <= mid && R <= right) {

			if (arr[L] <= arr[R])
				sortedArr[idx++] = arr[L++];
			else
				sortedArr[idx++] = arr[R++];

		}

		while (L <= mid) {
			sortedArr[idx++] = arr[L++];
		}

		while (R <= right) {
			sortedArr[idx++] = arr[R++];
		}

		for (int i = left, j = 0; i <= right; i++, j++) {
			arr[i] = sortedArr[j];
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

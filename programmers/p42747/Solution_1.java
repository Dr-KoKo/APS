package p42747;

import java.util.Arrays;
import java.util.Scanner;

class Solution_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.nextInt();
		}

		int ans = solution(arr);

		System.out.println(ans);
	}

	public static int solution(int[] citations) {
		int answer = 0;

		int len = citations.length;

		Arrays.sort(citations);

		

		return answer;
	}
}
package 정렬.K번째수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int[] command : commands) {
			int i = command[0];
			int j = command[1];
			int k = command[2];

			int[] arr = Arrays.copyOfRange(array, i - 1, j);

			Arrays.sort(arr);

			answer[i] = arr[k - 1];
		}

		return answer;
	}
}
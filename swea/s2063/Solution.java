package swea.s2063;

import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		int[] nums = new int[input.nextInt()];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = input.nextInt();
		}
		sort(nums);
		System.out.println(nums[nums.length / 2]);

	}

	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIdx = i;
			for (int j = i + 1; j < arr.length; j++)
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			int temp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = temp;
		}
	}
}

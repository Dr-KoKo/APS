package baekjoon.b4673;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Integer[] arr1 = new Integer[10001];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = i;
		}
		List<Integer> arr2 = new LinkedList<>(Arrays.asList(arr1));
		arr2.remove(0);

		for (int i = 1; i < arr1.length; i++) {
			Integer temp = i;
			while (true) {
				temp = temp + (temp / 1000) + ((temp % 1000) / 100) + ((temp % 100) / 10) + (temp % 10);
				arr2.remove(temp);
				System.out.println(temp);
				if (temp.intValue() > arr1.length)
					break;
			}
		}

		for (int i = 0; i < arr2.size(); i++) {
			System.out.println(arr2.get(i).toString());
		}

		int[] arr = new int[10001];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

		for (int i = 1; i < arr.length; i++) {
			int temp = i;
			while (true) {
				temp = temp + (temp / 1000) + (temp / 100) + (temp / 10) + (temp % 10);
				if (temp < arr.length)
					arr[temp] = 0;
				else
					break;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0)
				System.out.println(arr[i]);
		}
	}
}

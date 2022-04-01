package s1966;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

//		테스트 케이스 수 입력
		int T = input.nextInt(); input.nextLine(); // stream에 들어있는 '\n'제거?
		
//		테스트 케이스 실행
		for (int i = 0; i < T; i++) {
			int[] arr = new int[input.nextInt()]; input.nextLine(); // 배열길이정보를 입력받은 후 생성
			
			for (int j = 0; j < arr.length; j++) // 배열요소 입력
				arr[j] = input.nextInt();
			input.nextLine(); 

			sort(arr); // sort 메서드 호출

			print(i + 1, arr); // print 메서드 호출
//			System.out.println(printSB(i + 1, arr)); // printSB의 반환값을 출력
		}
		
		input.close();
		
	}

//	sort 메서드 : 오름차순 정렬
	public static int[] sort(int[] arr) {
		int temp;
		for (int i = arr.length - 1; i > 0; i--)
			for (int j = 0; j < i; j++)
				if (arr[j + 1] < arr[j]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
		return arr;
	}

//	print 메서드 : 출력(방법1)
	public static void print(int n, int[] arr) {
		System.out.printf("#%d ", n);
		for (int j = 0; j < arr.length; j++) {
			System.out.printf(arr[j] + " ");
		}
		System.out.println();
	}

//	printSB 메서드 : 출력(방법2)
//	public static StringBuilder printSB(int n, int[] arr) {
//		StringBuilder sb = new StringBuilder();
//		sb.append("#").append(n);
//		for (int j = 0; j < arr.length; j++) {
//			sb.append(" ").append(arr[j]);
//		}
//		sb.append("\n");
//		return sb;
//	}
}

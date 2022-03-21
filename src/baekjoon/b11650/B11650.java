package baekjoon.b11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11650 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer input = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(input.nextToken());
		
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			input = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(input.nextToken());
			arr[i][1] = Integer.parseInt(input.nextToken());
		}
		// 첫번째 sorting
		int[] count = new int[2*100000+1];
		for (int i = 0; i < N; i++) {
			++count[arr[i][1]+100000];
		}
		
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i-1]; 
		}
		
		int[][] sorted_1 = new int[N][2];
		for (int i = N-1; i >= 0; i--) {
			sorted_1[--count[arr[i][1]+100000]] = arr[i];
		}
		
		// 두번째 sorting
		count = new int[2*100000+1];
		for (int i = 0; i < N; i++) {
			++count[sorted_1[i][0]+100000];
		}
		
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i-1]; 
		}
		
		int[][] sorted_2 = new int[N][2];
		for (int i = N-1; i >= 0; i--) {
			sorted_2[--count[sorted_1[i][0]+100000]] = sorted_1[i];
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(sorted_2[i][0]).append(" ");
			sb.append(sorted_2[i][1]).append("\n");
		}
		
		System.out.print(sb);
		
	}
}

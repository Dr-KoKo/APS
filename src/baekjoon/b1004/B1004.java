package baekjoon.b1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1004 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		
		
		int T = Integer.parseInt(input.nextToken());
		int[] ans = new int[T+1];
		
		for (int tc = 1; tc <= T; tc++) {
			input = new StringTokenizer(br.readLine()," ");
			int[] start = new int[2];
			int[] end = new int[2];
			start[0] = Integer.parseInt(input.nextToken());
			start[1] = Integer.parseInt(input.nextToken());
			end[0] = Integer.parseInt(input.nextToken());
			end[1] = Integer.parseInt(input.nextToken());
			
			
			input = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(input.nextToken());
			for (int n = 0; n < N; n++) {
				input = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(input.nextToken());
				int y = Integer.parseInt(input.nextToken());
				int r = Integer.parseInt(input.nextToken());
				
				double rTos = Math.sqrt(((x-start[0])*(x-start[0])+(y-start[1])*(y-start[1])));
				double rToe = Math.sqrt(((x-end[0])*(x-end[0])+(y-end[1])*(y-end[1])));
				
				if((rTos<r&&rToe>r)||(rTos>r&&rToe<r)) {
					ans[tc]++;
				}
			}
		}
		
		for (int tc = 1; tc <= T; tc++) {
			System.out.println(ans[tc]);
		}
		
	}
}

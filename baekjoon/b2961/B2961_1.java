package b2961;

import java.util.Scanner;

public class B2961_1 {
	
	private static int N;
	private static int[][] data;
	private static int ans;

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// 1. 입력
		N = input.nextInt();
		
		data = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			
			 data[i][0] = input.nextInt(); // 신맛
			 data[i][1] = input.nextInt(); // 쓴맛
			
		}
		
		// 2. 계산 및 결과 출력
		comb(N);
		
		input.close();
		
	}
	
	/**
	 * 1.초기화 2.계산 3.출력 
	 * @param N : 데이터의 크기
	 */
	private static void comb(int N) {
		// 초기화
		ans = Integer.MAX_VALUE;
		
		boolean[] sel = new boolean[N];
		
		// 계산
		combUtil(0, sel);
		
		// 결과 출력
		System.out.println(ans);
		
	}

	/**
	 * 
	 * @param idx : base-case를 위한 param
	 * @param sel : 방문체크를 위한 배열
	 */
	private static void combUtil(int idx, boolean[] sel) {

		if(idx==N) {
			
			test(sel);
			
			return;
			
		}
		
		sel[idx] = true;
		combUtil(idx+1,sel);
		sel[idx] = false;
		combUtil(idx+1,sel);
		
	}

	private static void test(boolean[] sel) {

		boolean isEmpty = true;
		
		int sour = 1;
		int bitter = 0;

		for (int i = 0; i < N; i++) {
			
			if(sel[i]) {
				sour *= data[i][0];
				bitter += data[i][1];
				isEmpty = false;
			}
			
		}
		
		if(isEmpty) 
			return;
					
		ans = Math.min(ans, Math.abs(sour-bitter));
		
	}
	
}

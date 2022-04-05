package b3040;

import java.util.Scanner;

public class B3040 {
	
	private static int[] heights;
	private static int N,r;
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
	
		N = 9;
		r = 7;
		
		heights = new int[N];
		
		for (int i = 0; i < N; i++) {
			
			heights[i] = input.nextInt();
			
		}
		
		comb();
		
	}

	private static void comb() {
		
		boolean[] sel = new boolean[N];
		
		combUtil(0,0,sel);
		
	}

	private static void combUtil(int idx, int sidx,boolean[] sel) {
		
		if(sidx==r) {
			
			test(sel);

			return;
			
		} else if(idx==N) {
			
			return;
			
		}
		
		sel[idx] = true;
		combUtil(idx+1,sidx+1,sel);
		sel[idx] = false;
		combUtil(idx+1,sidx,sel);
		
	}

	private static void test(boolean[] sel) {

		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			
			if(sel[i])
				sum += heights[i];
			
		}
		
		if(sum==100) {
			
			for (int i = 0; i < N; i++) {
				
				if(sel[i])
					System.out.println(heights[i]);
				
			}
			
		}
		
	}
	
}

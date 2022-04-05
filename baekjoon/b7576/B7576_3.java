package b7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7576_3 {

	static int N, M;
	static int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};

	static class Tomato {
		int r, c;

		Tomato(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		M = input.nextInt();
		N = input.nextInt();

		int[][] box = new int[N][M];

		int empty = N * M;

		Queue<Tomato> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				box[i][j] = input.nextInt();

				switch (box[i][j]) {
				case 1:
					queue.add(new Tomato(i, j));
					empty--;
					break;

				case -1:
					empty--;
					break;
				}

			}
		}
		
		int days = 0;
		
		while(!queue.isEmpty() && empty!=0) {
			
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				
				Tomato t = queue.poll();
				
				for (int d = 0; d < drc.length; d++) {
					int nr = t.r+drc[d][0];
					int nc = t.c+drc[d][1];
					
					if(!inBound(nr,nc)||box[nr][nc]!=0) 
						continue;
					
					box[nr][nc] = 1;
					queue.add(new Tomato(nr,nc));
					--empty;
					
				}
				
			}
			
			++days;
			
		}
		
		System.out.println(empty == 0? days : -1);

	}

	private static boolean inBound(int nr, int nc) {
		return nr>=0&&nr<N&&nc>=0&&nc<M;
	}
	
}

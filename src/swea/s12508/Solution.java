package swea.s12508;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int T = input.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = input.nextInt();
			int M = input.nextInt();
			Queue<Integer> Ci = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				Ci.add(input.nextInt());
			}
			
			Queue<Integer> oven = new LinkedList<>();
			int cnt = 0;
			while (cnt < M) {
				int i = 0;
				while(true) {
				if (oven.peek() == null) {
					oven.add(Ci.peek());
				}
				if(oven.peek()/2==0) {
					oven.remove();
					
				}
				}
			}
		}
	}
}

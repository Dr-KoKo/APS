package s10726;

import java.util.Scanner;

public class S10726 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = input.nextInt();
			int M = input.nextInt();
			
			boolean isFlag = true;
			
			for (int i = N-1; i >= 0; i--) {
				
				if ((M & (1 << i)) > 0) {
					continue;
				} else {
					isFlag = false;
					break;
				}
				
			}
			
			sb.append("#").append(tc).append(" ");
			
			if(isFlag)
				sb.append("ON").append("\n");
			else
				sb.append("OFF").append("\n");
			
		}
		
		System.out.print(sb);
		
		input.close();

	}
}

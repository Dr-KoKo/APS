package s1204;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1 {
	
	static Scanner input = new Scanner(System.in);
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 1.입력
			int t = input.nextInt();
			input.nextLine();
			int[] cntScore = new int[101];
			int len = cntScore.length;

//			방법 1 : parsing(String[] to Int[]) 후 cntScore 계산
			int[] scores = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int s : scores) {
				cntScore[s]++;
			}

//			방법 2 : Scanner.nextInt() 메서드를 이용해 cntScore 계산
//			for (int i = 0; i < 1000; i++) {
//				cntScore[input.nextInt()]++; // input에 대응되는 count의 index에 +1
//			}

			// 2.계산
			int maxV = 0;
			int ans = 0;
			for (int i = 0; i < len; i++) {
				if (cntScore[i] >= maxV) {
					maxV = cntScore[i];
					ans = i;
				}
			}

			sb.append("#").append(t).append(" ").append(ans).append("\n");
			
		}
		// 3.출력
		System.out.print(sb);
		
	}
}
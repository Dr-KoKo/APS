package swea.s1204;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
//	Scanner 인스턴스 생성
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
//		테스트 케이스 수 입력
		int T = input.nextInt();

//		테스트 케이스 실행
		for (int tc = 1; tc <= T; tc++) {
//			입력
			int t = input.nextInt(); // 테스트 번호 입력
			int[] cntScore = new int[101]; // 빈도확인을 위한 count 배열
			int len = cntScore.length;
			
			input.nextLine();
//			방법 1 : parsing(String[] to Int[]) 후 cntScore 계산
			int[] scores = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int s : scores) {
				cntScore[s]++;
			}
			
////			방법 2 : Scanner.nextInt() 메서드를 이용해 cntScore 계산
//			for (int i = 0; i < 1000; i++) {
//				cntScore[input.nextInt()]++; // input에 대응되는 count의 index에 +1
//			}

//			계산
			int maxV = 0; // 최대 빈도 수
			int ans = 0; // 최대 빈도 점수
			for (int i = 0; i < len; i++) {
				if (cntScore[i] >= maxV) { // 더 큰 빈도의 점수 발견 시
					maxV = cntScore[i]; // maxV 재할당
					ans = i; // maxIdx 재할당
				}
			}

//			출력
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}

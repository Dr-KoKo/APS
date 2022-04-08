package s1952;

import java.util.Scanner;

public class S1952 {

	static int[] plan;
	static int day, mon, tMon, year;
	static int ans;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			day = input.nextInt();
			mon = input.nextInt();
			tMon = input.nextInt();
			year = input.nextInt();

			plan = new int[12];

			for (int i = 0; i < 12; i++) {

				plan[i] = input.nextInt();

			}

			cal();

			sb.append("#").append(tc);
			sb.append(" ").append(ans);
			sb.append("\n");
			
		}
		
		System.out.print(sb);
		
		input.close();

	}

	private static void cal() {

		ans = year;

		calUtil(0, 0);

	}

	private static void calUtil(int idx, int cost) {

		if (cost >= ans)
			return;

		if (idx >= 12) {
			ans = Math.min(ans, cost);
			return;
		}

		calUtil(idx + 1, cost + plan[idx] * day);
		calUtil(idx + 1, cost + mon);
		calUtil(idx + 3, cost + tMon);

	}
}

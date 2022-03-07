package baekjoon.b9239;
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int Xn = (int) (input.nextDouble() * 10000);
		int n = 0;
		for (int i = 1; i < 100000000; i++) {
			if (Xn * i % 10000 == 0) {
				Xn = Xn * i / 10000;
				n = i;
				break;
			}
		}

		boolean isNoSolution = true;
		for (int i = 1; i < 100000000 / Xn; i++) {
			String XNiStr = String.valueOf((Xn * i));// �뮘 �닽�옄
			String niStr = String.valueOf(n * i); // �븵 �닽�옄

			outer: if (XNiStr.charAt(XNiStr.length() - 1) == niStr.charAt(0) && XNiStr.length() == niStr.length()) {
				for (int j = 0; j < XNiStr.length() - 1; j++) {
					if (XNiStr.charAt(j) != niStr.charAt(j + 1))
						break outer;
				}
				sb.append(niStr).append("\n");
				isNoSolution = false;
			}
		}

		System.out.print(sb);

		if (isNoSolution)
			System.out.println("No solution");

	}

}
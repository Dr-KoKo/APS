package b1463;

import java.util.Scanner;

public class B1463 {
	private static int[] mem = new int[1000000 + 1];

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();

		int ans = cal(N, 0);

		System.out.println(ans);

		input.close();
	}

	private static int cal(int n, int i) {
		if (n == 1) {
			return i;
		}

		int ret = Integer.MAX_VALUE;

		if (n % 3 == 0) {
			if (mem[n/3] != 0)
				ret = Math.min(ret, mem[n/3]);
			else {
				mem[n/3] = cal(n / 3, i + 1);
				ret = Math.min(ret, mem[n/ 3]);
			}
		}

		if (n % 2 == 0) {
			if (mem[n] != 0)
				ret = Math.min(ret, mem[n]);
			else {
				mem[n / 2] = cal(n / 2, i + 1);
				ret = Math.min(ret, mem[n / 2]);
			}
		}

		if (mem[n - 1] != 0)
			ret = Math.min(ret, mem[n - 1]);
		else {
			mem[n - 1] = cal(n - 1, i + 1);
			ret = Math.min(ret, cal(n - 1, mem[n - 1]));
		}

		return ret;
	}

}

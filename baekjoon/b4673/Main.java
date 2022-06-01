package b4673;

public class Main {

	static boolean[] check = new boolean[10001];

	public static void main(String[] args) {

		for (int i = 1; i <= 10000; i++) {

			int self = i;

			while (true) {
				self = self(self);

				if (self == i || self > 10000) {
					break;
				}

				check[self] = true;
			}

		}

		for (int i = 1; i <= 10000; i++) {
			if (!check[i]) {
				System.out.println(i);
			}
		}

	}

	private static int self(int N) {

		int ret = N;

		while (N / 10 != 0 || N % 10 != 0) {
			ret += (N % 10);
			N /= 10;
		}

		return ret;

	}

}

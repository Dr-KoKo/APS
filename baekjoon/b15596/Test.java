package b15596;

public class Test {
	long sum(int[] a) {
		long ans = 0;
		for (int i : a) {
			ans += (long) i;
		}
		return ans;
	}
}

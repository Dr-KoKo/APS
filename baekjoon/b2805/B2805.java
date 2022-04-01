package b2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2805 {
	private static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer input = new StringTokenizer(br.readLine());
		N = Integer.parseInt(input.nextToken());
		int M = Integer.parseInt(input.nextToken());

		int[] heights = new int[N];
		int max = Integer.MIN_VALUE;

		input = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			heights[i] = Integer.parseInt(input.nextToken());
			if(max<heights[i])
				max = heights[i];
		}

		int ans = find(heights, 0, max, M);

		System.out.println(ans);

	}

	private static int find(int[] heights, int start, int end, int M) {
		while (start < end) {
			int mid = (start + end) / 2;
			long sum = cut(heights, mid);
			if (sum > M)
				start = mid;
			else if (sum < M)
				end = mid - 1;
			else
				return mid;
		}
		return start;
	}

	private static long cut(int[] heights, int h) {
		long ret = 0;
		for (int i = 0; i < N; i++) {
			if (heights[i] - h > 0)
				ret += heights[i] - h;
		}
		return ret;
	}
}

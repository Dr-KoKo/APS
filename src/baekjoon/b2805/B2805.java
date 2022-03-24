
package baekjoon.b2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer input = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(input.nextToken());
		int M = Integer.parseInt(input.nextToken());

		int[] heights = new int[N];
		int max = Integer.MIN_VALUE;

		input = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			heights[i] = Integer.parseInt(input.nextToken());
			max = Math.max(max, heights[i]);
		}

		int ans = find(heights, 0, max, M);

		System.out.println(ans);

	}

	private static int find(int[] heights, int start, int end, int M) {
		while (start < end) {
			int mid = (start + end) / 2;
			if (cut(heights, mid) > M)
				start = mid;
			else if (cut(heights, mid) < M)
				end = mid - 1;
			else if (cut(heights, mid) == M)
				return mid;
		}
		return start;
	}

	private static int cut(int[] heights, int h) {
		int ret = 0;
		for (int i = 0; i < heights.length; i++) {
			if (heights[i] - h > 0)
				ret += heights[i] - h;
		}
		return ret;
	}
}

package b1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1152_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer input = new StringTokenizer(br.readLine(), " ");

		int cnt = 0;
		while (input.hasMoreTokens()) {
			if (input.nextToken().equals("")) {
				continue;
			}
			++cnt;
		}

		System.out.println(cnt);

	}
}

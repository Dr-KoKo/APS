package b1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		input = input.toLowerCase();

		int[] count = new int[26];
		for (char c : input.toCharArray()) {
			++count[c - 'a'];
		}

		int idx = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < count.length; i++) {
			if (max < count[i]) {
				idx = i;
				max = count[i];
			}
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] == max && i != idx) {
				System.out.println("?");
				return;
			}
		}

		System.out.printf("%c", 'A' + idx);

	}
}

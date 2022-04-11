package s5658;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class S5658 {

	static int N, K;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = input.nextInt();
			K = input.nextInt();
			input.nextLine();

			String str = input.nextLine();
			String temp = str.substring(0, N / 4);
			String fin = str + temp;

			List<Long> ans = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				Long val = Long.parseLong(fin.substring(i, i + N / 4), 16);
				ans.add(val);
			}
			
			HashSet<Long> set = new HashSet<>(ans);
			ans.clear();
			ans.addAll(set);

			Collections.sort(ans, new Comparator<Long>() {
				@Override
				public int compare(Long o1, Long o2) {
					if(o2>o1)
						return 1;
					else 
						return -1;
				}
			});
			
			sb.append("#").append(tc).append(" ").append(ans.get(K - 1)).append("\n");

		}

		System.out.print(sb);

		input.close();

	}

}

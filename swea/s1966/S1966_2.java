package s1966;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class S1966_2 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			List<Integer> list = new LinkedList<>();

			int N = input.nextInt();

			for (int n = 0; n < N; n++) {

				list.add(input.nextInt());

			}
			
			Collections.sort(list);

			sb.append("#").append(tc);

			Iterator<Integer> it = list.iterator();
			
			while(it.hasNext()) {
				sb.append(" ").append(it.next());
			}

			sb.append("\n");

		}

		System.out.print(sb);

		input.close();

	}

}

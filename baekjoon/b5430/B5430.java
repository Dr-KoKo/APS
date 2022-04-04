package b5430;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class B5430 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int T = input.nextInt();
		input.nextLine();

		outer: for (int tc = 1; tc <= T; tc++) {

			char[] order = input.nextLine().toCharArray();

			int n = input.nextInt();

			input.nextLine();
			String temp = input.nextLine();

			String[] str = temp.substring(1, temp.length() - 1).split(",");

			Deque<Integer> dq = new ArrayDeque<>();

			for (int s = 0; s < str.length; s++) {

				try {
					dq.add(Integer.parseInt(str[s]));
				} catch (Exception e) {
					System.out.println("error");
					continue outer;
				}

			}

			boolean flag = true;

			for (char o : order) {

				switch (o) {
				case 'R':
					flag = !flag;
					break;
				case 'D':
					try {
						if (flag)
							dq.removeFirst();
						else
							dq.removeLast();
					} catch (Exception e) {
						System.out.println("error");
						continue outer;
					}

				}

			}

			if (flag)
				System.out.println(dq.toString().replace(" ", ""));
			else {
				List<Integer> list = new LinkedList<>();

				while (!dq.isEmpty()) {
					list.add(dq.removeLast());
				}

				System.out.println(list.toString().replace(" ", ""));

			}

		}
		
		input.close();

	}

}

package b10951;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (input.hasNextLine()) {
			StringTokenizer st = new StringTokenizer(input.nextLine());

			System.out.println(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
		}
	}
}

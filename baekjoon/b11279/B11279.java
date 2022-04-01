package b11279;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B11279 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();

		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

		for (int n = 1; n <= N; n++) {

			int i = input.nextInt();

			if(i!=0)
				pq.add(i);
			else {
				if(pq.isEmpty())
					System.out.println("0");
				else 
					System.out.println(pq.remove());
			}

		}

		input.close();

	}
}
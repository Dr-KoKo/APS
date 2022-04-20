package s2383;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 2383.점심 식사시간
// 완전탐색
public class Solution_2 {

	static Scanner input = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();

	static class Person {
		int r, c;
		Stair allocated;

		public Person(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Stair {
		int r, c;
		int len;
		int occupied;
		List<Person> ocPerson = new ArrayList<>();

		public Stair(int r, int c, int len) {
			this.r = r;
			this.c = c;
			this.len = len;
		}
	}

	static int[][] map;
	static int ans;
	static List<Person> personList;
	static List<Stair> stairList;

	public static void main(String[] args) {

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = input.nextInt();

			map = new int[N][N];

			personList = new ArrayList<>();
			stairList = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					map[i][j] = input.nextInt();

					if (map[i][j] == 1) {
						personList.add(new Person(i, j));
					} else if (map[i][j] > 1) {
						stairList.add(new Stair(i, j, map[i][j]));
					}

				}
			}

			ans = Integer.MAX_VALUE;
			allocate(0, 0);

			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}

		System.out.print(sb);

		input.close();

	}

	private static void allocate(int idx, int maxVal) {

		if (maxVal > ans)
			return;

		if (idx == personList.size()) {
			if (ans > maxVal)
				ans = maxVal;
			return;
		}

		Person person = personList.get(idx);

		for (int i = 0; i < stairList.size(); i++) {

			Stair stair = stairList.get(i);

			int time = checkTime(person, stair);
			
			if (stair.occupied >= 3) {
				
				boolean[] checked = new boolean[stair.occupied];
				
				
				for (int j = 0; j < stair.ocPerson.size()-2; j++) {
					int min = Integer.MAX_VALUE;
					for (int p = 0; p < stair.ocPerson.size(); p++) {
						stair.ocPerson.get(p);
					}
					
				}

			}

			person.allocated = stair;
			++stair.occupied;


			allocate(idx + 1, maxVal > time ? maxVal : time);
		}

	}

	private static int checkTime(Person person, Stair stair) {
		return Math.abs(person.r - stair.r) + Math.abs(person.c - stair.c) + stair.len;
	}

}

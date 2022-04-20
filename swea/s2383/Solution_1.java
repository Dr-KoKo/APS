package s2383;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 2383.점심 식사시간
// 선배정 후 조정
public class Solution_1 {

	static Scanner input = new Scanner(System.in);

	static class Person {
		int r, c;
		Stair priority;

		public Person(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Stair {
		int r, c;
		int len;
		int occupied;
		List<Person> allocated = new LinkedList<>();

		public Stair(int r, int c, int len) {
			this.r = r;
			this.c = c;
			this.len = len;
		}
	}

	static int[][] map;
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

			for (int i = 0; i < personList.size(); i++) {
				firstAllocate(personList.get(i));
			}
			
			

		}

	}

	private static void firstAllocate(Person person) {

		int minIdx = -1;
		int minVal = Integer.MAX_VALUE;

		for (int i = 0; i < stairList.size(); i++) {
			Stair stair = stairList.get(i);
			int temp = Math.abs(person.r - stair.r) + Math.abs(person.c - stair.c) + stair.len;
			if (minVal > temp) {
				minIdx = i;
				minVal = temp;
			}
		}

		person.priority = stairList.get(minIdx);
		stairList.get(minIdx).allocated.add(person);
		++stairList.get(minIdx).occupied;

	}
}

package s2383;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 2383.점심 식사시간
// 계단 2개로 고정인지 모르고 뻘짓함
// 계단이 2개라면 'Queue'를 쓰면 쉬울 거 같다.
public class Solution_3 {

	static Scanner input = new Scanner(System.in);

	static class Person {
		int r, c;
		int timeToStair;

		public Person(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Stair {
		int r, c;
		int len;

		public Stair(int r, int c, int len) {
			this.r = r;
			this.c = c;
			this.len = len;
		}
	}

	static int[][] map;
	static List<Person> personList;
	static List<Stair> stairList;
	static int ans;

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
			allocate(0, new boolean[personList.size()]);

			System.out.println(ans);

		}

	}

	private static void allocate(int idx, boolean[] visited) {

		if (idx == personList.size()) {
			if (cal(visited) > ans) {
				for (int i = 0; i < visited.length; i++) {
					if (visited[i])
						System.out.print(i);
				}
				System.out.println();
			}
			ans = Math.min(ans, cal(visited));
			return;
		}

		visited[idx] = true;
		allocate(idx + 1, visited);
		visited[idx] = false;
		allocate(idx + 1, visited);

	}

	private static int cal(boolean[] visited) {

		int numIn0 = 0;
		int numIn1 = 0;

		for (int i = 0; i < visited.length; i++) {
			Person person = personList.get(i);

			if (visited[i]) {
				Stair stair = stairList.get(0);
				person.timeToStair = checkTime(person, stair);
				++numIn0;
			} else {
				Stair stair = stairList.get(1);
				person.timeToStair = checkTime(person, stair);
				++numIn1;
			}
		}

		int[] arrIn0 = new int[numIn0];
		int[] arrIn1 = new int[numIn1];

		Arrays.sort(arrIn0);
		Arrays.sort(arrIn1);

		for (int i = 0; i < arrIn0.length - 2; i++) {
			if (arrIn0[i] + stairList.get(0).len > arrIn0[i + 2])
				arrIn0[i + 2] = arrIn0[i] + stairList.get(0).len;
		}
		for (int i = 0; i < arrIn1.length - 2; i++) {
			if (arrIn1[i] + stairList.get(1).len > arrIn1[i + 2])
				arrIn1[i + 2] = arrIn1[i] + stairList.get(1).len;
		}

		int temp1 = arrIn0.length > 0 ? arrIn0[arrIn0.length - 1] : Integer.MIN_VALUE;
		int temp2 = arrIn1.length > 0 ? arrIn1[arrIn1.length - 1] : Integer.MIN_VALUE;

		return temp1 > temp2 ? temp1 : temp2;

	}

	private static int checkTime(Person person, Stair stair) {
		return Math.abs(person.r - stair.r) + Math.abs(person.c - stair.c);
	}
}

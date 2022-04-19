package s1873;

import java.util.Scanner;

public class Solution {
	private static char[][] map;
	private static int[] pos;
	private static int H, W;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = input.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			H = input.nextInt(); // H 변수
			W = input.nextInt(); // W 변수
			input.nextLine();
			map = new char[H][W]; // map 변수
			for (int i = 0; i < H; i++) {
				String str = input.nextLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			pos = new int[2]; // pos 변수
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					char temp = map[i][j];
					if (temp == '^' || temp == 'v' || temp == '<' || temp == '>') {
						pos[0] = i;
						pos[1] = j;
						break;
					}
				}
			}

			int N = input.nextInt();
			input.nextLine();
			String order = input.nextLine();
			for (int n = 0; n < N; n++) {
				execute(order.charAt(n));
			}

			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < H; i++) {
				sb.append(map[i]).append("\n");
			}
			System.out.print(sb.toString());
			sb.setLength(0);
		}

		input.close();

	}

	private static void execute(char order) {
		switch (order) {
		case 'U':
			map[pos[0]][pos[1]] = '^';
			if (inBound(pos[0] - 1, pos[1]) && map[pos[0] - 1][pos[1]] == '.') {
				map[pos[0] - 1][pos[1]] = '^';
				map[pos[0]][pos[1]] = '.';
				pos[0]--;
			}
			break;
		case 'D':
			map[pos[0]][pos[1]] = 'v';
			if (inBound(pos[0] + 1, pos[1]) && map[pos[0] + 1][pos[1]] == '.') {
				map[pos[0] + 1][pos[1]] = 'v';
				map[pos[0]][pos[1]] = '.';
				pos[0]++;
			}
			break;
		case 'L':
			map[pos[0]][pos[1]] = '<';
			if (inBound(pos[0], pos[1] - 1) && map[pos[0]][pos[1] - 1] == '.') {
				map[pos[0]][pos[1] - 1] = '<';
				map[pos[0]][pos[1]] = '.';
				pos[1]--;
			}
			break;
		case 'R':
			map[pos[0]][pos[1]] = '>';
			if (inBound(pos[0], pos[1] + 1) && map[pos[0]][pos[1] + 1] == '.') {
				map[pos[0]][pos[1] + 1] = '>';
				map[pos[0]][pos[1]] = '.';
				pos[1]++;
			}
			break;
		case 'S':
			shoot();
		}
	}

	private static void shoot() {
		int x = 0;
		int y = 0;
		switch (map[pos[0]][pos[1]]) {
		case '^':
			x = -1;
			break;
		case 'v':
			x = 1;
			break;
		case '<':
			y = -1;
			break;
		case '>':
			y = 1;
			break;
		}

		int[] target = { pos[0], pos[1] };
		while (true) {
			if (!inBound(target[0], target[1]) || map[target[0]][target[1]] == '#')
				break;
			else if (map[target[0]][target[1]] == '*') {
				map[target[0]][target[1]] = '.';
				break;
			}

			target[0] += x;
			target[1] += y;
		}
	}

	private static boolean inBound(int x, int y) {
		return x >= 0 && x < H && y >= 0 && y < W;
	}
}

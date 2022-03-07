package swea.s1218;

import java.util.Scanner;

public class Solution {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int N = input.nextInt();
			input.nextLine();

			char[] brackets = input.nextLine().toCharArray();

			System.out.printf("#%d %d\n", tc, isValid(brackets));
		}
	}

	private static int isValid(char[] target) {
		char[] stack = new char[target.length];
		int top = -1;

		for (int i = 0; i < target.length; i++) {
			switch (target[i]) {
			case '(':
			case '{':
			case '[':
			case '<':
//				push
				if (top >= target.length) // stack overflow
					return 0;
				else 
					stack[++top] = target[i];
				break;
			case ')':
			case '}':
			case ']':
			case '>':
//				pop
				char switchedTop = switchBracket(stack[top]);
				if (switchedTop == target[i]) { // 마지막 입력과 닫는 괄호가 일치되면 top은 소멸
					top--;
				} else if (switchedTop != target[i]) // 불일치되면 return 0
					return 0;

				if (top < -1) // 닫는 괄호가 먼저 나오는 경우
					return 0;
			}
		}

		return 1;
	}

	private static char switchBracket(char ch) {
		char temp = ch;
		switch (temp) {
		case '(':
			temp = ')';
			break;
		case '{':
			temp = '}';
			break;
		case '[':
			temp = ']';
			break;
		case '<':
			temp = '>';
			break;
		case ')':
			temp = '(';
			break;
		case '}':
			temp = '{';
			break;
		case ']':
			temp = '[';
			break;
		case '>':
			temp = '<';
			break;
		}
		return temp;
	}
}

package b4949;

import java.util.Scanner;
import java.util.Stack;

public class B4949 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		// InputStream에 데이터가 남아있을 때까지 테스트 실행
		while (input.hasNextLine()) {
			// Stack 및 (결과 출력을 위한) flag 생성 
			Stack<Character> stack = new Stack<>();
			boolean ans = true;
			// InputStream에서 한 줄 읽어서 char배열에 저장
			char[] line = input.nextLine().toCharArray();
			// 그런데 그 첫 값이 .이면 테스트 실행 X
			if(line[0]=='.')
				continue;
			
			// 테스트 실행
			outer: for (int i = 0; i < line.length; i++) {

				char ch = line[i];

				switch (ch) {
				// 여는 괄호면 stack에 push
				case '(':
				case '[':
					stack.push(ch);
					break;
				// 닫는 괄호면 1.')'인 경우
				case ')':
					// stack이 비어있거나 그 값이 '('가 아니면 테스트 실패
					if (!stack.isEmpty() && stack.pop() == '(')
						break;
					else {
						ans = false;
						break outer;
					}
				// 2.']'인 경우
				case ']':
					// stack이 비어있거나 그 값이 '['가 아니면 테스트 실패
					if (!stack.isEmpty() && stack.pop() == '[')
						break;
					else {
						ans = false;
						break outer;
					}

				}

			}
			
			if(!stack.isEmpty())
				ans = false;

			if (ans)
				System.out.println("yes");
			else
				System.out.println("no");

		}

		input.close();

	}

}

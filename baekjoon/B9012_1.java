package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class B9012_1 {
    private static int N;
    private static Stack<Character> stack;

    private static StringBuilder sb;

    public static void main(String[] args) {
        input();
        print();
    }

    private static void print() {
        System.out.println(sb);
    }

    private static void check(Scanner input) {
        for (char ch : input.next().toCharArray()) {
            switch (ch) {
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        sb.append("NO").append('\n');
                        return;
                    }
            }
        }

        if(stack.isEmpty()){
            sb.append("YES").append('\n');
        } else {
            sb.append("NO").append('\n');
        }
    }

    private static void input() {
        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            stack = new Stack<>();
            check(input);
        }
    }
}

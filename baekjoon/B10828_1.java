package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class B10828_1 {
    private static int N;

    private static Stack<Integer> stack;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        print();
    }

    private static void print() {
        System.out.println(sb);
    }

    private static void operate(Scanner input) {
        for (int i = 1; i <= N; i++) {
            switch (input.next()) {
                case "push":
                    stack.push(input.nextInt());
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        sb.append("-1").append('\n');
                        break;
                    }
                    sb.append(stack.pop()).append('\n');
                    break;
                case "size":
                    sb.append(stack.size()).append('\n');
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        sb.append("-1").append('\n');
                        break;
                    }
                    sb.append(stack.peek()).append('\n');
                    break;
            }
        }
    }

    private static void input() {
        Scanner input = new Scanner(System.in);

        N = input.nextInt();

        stack = new Stack<>();

        operate(input);

        input.close();
    }
}

package baekjoon;

import java.util.*;

public class B10845_1 {
    private static int N;

    private static Deque<Integer> deque;
    private static StringBuilder sb;

    public static void main(String[] args) {
        input();
        print();
    }

    private static void print() {
        System.out.println(sb);
    }

    private static void input() {
        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        deque = new LinkedList<>();
        sb = new StringBuilder();

        operate(input);
    }

    private static void operate(Scanner input) {
        for (int i = 1; i <= N; i++) {
            switch (input.next()) {
                case "push":
                    deque.add(input.nextInt());
                    break;
                case "pop":
                    if (deque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(deque.pop()).append('\n');
                    }
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(deque.peekFirst()).append('\n');
                    }
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(deque.peekLast()).append('\n');
                    }
                    break;
                case "size":
                    sb.append(deque.size()).append('\n');
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;
            }
        }
    }
}

package baekjoon;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class B10866_1 {
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
                case "push_front":
                    deque.addFirst(input.nextInt());
                    break;
                case "push_back":
                    deque.addLast(input.nextInt());
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(deque.pollFirst()).append('\n');
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(deque.pollLast()).append('\n');
                    }
                    break;
                case "size":
                    sb.append(deque.size()).append('\n');
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append('\n');
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
            }
        }
    }
}

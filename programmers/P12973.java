package programmers;

import java.util.Stack;

public class P12973 {
    private StringBuilder sb = new StringBuilder();

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if (stack.isEmpty())
            return 1;
        return 0;
    }
}

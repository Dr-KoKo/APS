package programmers;

import java.util.Stack;

public class P12909 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character ch : s.toCharArray()) {
            if(ch=='(') {
                stack.add(ch);
            } else if (ch==')') {
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}

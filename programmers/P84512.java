package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class P84512 {

    private final int MAX_LENGTH = 5;
    private final String[] CHAR_ARR = new String[]{"A", "E", "I", "O", "U"};
    private Set<String> set = new HashSet<>();

    public int solution(String word) {
        for (int i = 1; i <= 5; i++) {
            addSet(0, i, "");
        }

        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list);

        int answer = list.indexOf(word);

        return answer;
    }

    private void addSet(int dept, int len, String str) {
        if (dept > MAX_LENGTH) {
            return;
        }

        set.add(str);

        for (String s : CHAR_ARR) {
            addSet(dept+1, len, str + s);
        }
    }

}

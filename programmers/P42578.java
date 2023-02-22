package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class P42578 {
    private Map<String, HashSet<String>> data = new HashMap<>();
    public int solution(String[][] clothes) {
        int answer = 1;

        for (String[] cloth : clothes) {
            HashSet<String> clothSet = data.getOrDefault(cloth[1], new HashSet<>(Arrays.asList("none")));

            clothSet.add(cloth[0]);

            data.put(cloth[1], clothSet);
        }

        for (HashSet<String> clothSet : data.values()) {
            answer *= clothSet.size();
        }

        answer -= 1;

        return answer;
    }

}

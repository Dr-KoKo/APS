package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class P42746 {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] numberArr = Arrays.stream(numbers).mapToObj(i -> String.valueOf(i)).toArray(String[]::new);

        Arrays.sort(numberArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo((o1 + o2));
            }
        });

        for (String s : numberArr) {
            sb.append(s);
        }

        if (sb.charAt(0) == '0') return "0";

        return sb.toString();
    }
}

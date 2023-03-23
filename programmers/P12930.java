package programmers;

import java.util.StringTokenizer;

public class P12930 {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuilder sb = new StringBuilder();

        while(st.hasMoreTokens()) {
            String next = st.nextToken().toLowerCase();

            if(" ".equals(next)) {
                sb.append(" ");
                continue;
            }

            char[] chars = next.toCharArray();
            for (int i = 0; i < chars.length; i+=2) {
                chars[i] = Character.toUpperCase(chars[i]);
            }

            sb.append(chars);
        }

        return sb.toString();
    }
}

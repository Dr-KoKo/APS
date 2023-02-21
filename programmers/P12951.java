package programmers;

import java.util.StringTokenizer;

public class P12951 {
    public static String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            String str = st.nextToken().toLowerCase();

            if(" ".equals(str)){
                sb.append(" ");
            } else {
                sb.append(Character.toUpperCase(str.charAt(0))).append(str.substring(1));
            }
        }

        return sb.toString();
    }
}

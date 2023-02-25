package baekjoon;

import java.util.Scanner;
import java.util.StringTokenizer;

public class B1259_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (sc.hasNext()) {
            String num = sc.next();

            if ("0".equals(num)) break;

            if (check(num)) sb.append("yes").append('\n');
            else sb.append("no").append('\n');
        }

        System.out.println(sb);
    }

    private static boolean check(String num) {
        int len = num.length();

        for (int i = 0; i < len; i++) {
            if (num.charAt(i) != num.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

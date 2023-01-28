package baekjoon;

import java.util.Scanner;

public class B1427_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int[] cnt = new int[10];

        for (char ch : sc.next().toCharArray()) {
            cnt[ch-'0']++;
        }

        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < cnt[i]; j++) {
                sb.append(i);
            }
        }

        System.out.println(sb);
    }
}

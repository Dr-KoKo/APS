package baekjoon;

import java.util.Scanner;

public class B2566_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int temp = Integer.MIN_VALUE;
        int row = -1;
        int col = -1;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int inNum = sc.nextInt();

                if (temp < inNum) {
                    temp = inNum;
                    row = i + 1;
                    col = j + 1;
                }
            }
        }

        System.out.println(temp);
        System.out.println(row + " " + col);
    }
}

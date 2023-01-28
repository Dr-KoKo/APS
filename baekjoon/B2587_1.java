package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B2587_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        int avg = 0;
        for (int i = 0; i < 5; i++) {
            avg += arr[i];
        }
        avg /= 5;

        int mid = -1;
        Arrays.sort(arr);
        mid = arr[2];

        System.out.println(avg);
        System.out.println(mid);
    }
}

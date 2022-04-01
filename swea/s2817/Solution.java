package s2817;

import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
    public static Scanner input = new Scanner(System.in);
    private static int[] arr;
    private static boolean[] isSelected;
    private static int cnt;
 
    public static void main(String[] args) {
        int T = input.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = input.nextInt();
            int K = input.nextInt();
            input.nextLine();
            
            arr = new int[N];
            arr = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            isSelected = new boolean[N];
            
 
            cnt = 0;
            cal(N, K);
            System.out.printf("#%d %d\n", tc, cnt);
        }
    }
 
    private static void cal(int n, int k) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isSelected[i])
                sum += arr[i];
        }
        if (sum == k) {
            cnt++;
            return;
        } else if (n == 0)
            return;
 
        isSelected[n - 1] = true;
        cal(n - 1, k);
        isSelected[n - 1] = false;
        cal(n - 1, k);
 
    }
}
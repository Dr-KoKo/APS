package baekjoon;

import java.util.Scanner;

public class B2738_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] matrixA = new int[N][M];
        int[][] matrixB = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrixA[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrixB[i][j] = sc.nextInt();
            }
        }

        int[][] matrixC = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
                sb.append(matrixC[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}

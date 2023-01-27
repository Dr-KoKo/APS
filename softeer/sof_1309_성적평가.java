package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sof_1309_성적평가 {
    private static int N;
    private static int[][] scores;
    private static int[][] countScores;

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        input();

        cal();

        print();
    }

    private static void print() {
        System.out.println(sb);
    }

    private static void cal() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = 1;

                cnt += countScores[i][scores[i][j]+1];

                sb.append(cnt).append(' ');
            }
            sb.append('\n');
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        scores = new int[4][N];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());

                scores[i][j] = temp;
                scores[3][j] += temp;
            }
        }

        countScores = new int[4][1+3000+1];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < N; j++) {
                countScores[i][scores[i][j]]++;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 3000; j >= 0; j--) {
                countScores[i][j] += countScores[i][j+1];
            }
        }

        sb = new StringBuilder();
    }
}

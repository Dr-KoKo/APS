package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sof_395_금고털이 {
    private static int W;
    private static int N;
    private static int ans;
    private static int[][] MP;

    public static void main(String[] args) throws IOException {
        input();
        cal();
        print();
    }

    private static void print() {
        System.out.println(ans);
    }

    private static void cal() {
        Arrays.sort(MP, (o1, o2) -> o2[1] - o1[1]);

        int temp = W;
        for (int i = 0; i < N; i++) {
            if (temp >= MP[i][0]) {
                temp -= MP[i][0];
                ans += MP[i][0] * MP[i][1];
            } else {
                ans += (temp) * MP[i][1];
                break;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        MP = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            MP[i][0] = Integer.parseInt(st.nextToken());
            MP[i][1] = Integer.parseInt(st.nextToken());
        }
        ans = 0;
    }
}

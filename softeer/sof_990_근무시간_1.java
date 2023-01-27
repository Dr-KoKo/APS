package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sof_990_근무시간_1 {
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        initialize();

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " :");

            int H1 = Integer.parseInt(st.nextToken());
            int M1 = Integer.parseInt(st.nextToken());
            int H2 = Integer.parseInt(st.nextToken());
            int M2 = Integer.parseInt(st.nextToken());

            ans += (H2 - H1) * 60 + (M2 - M1);
        }

        print();
    }

    private static void print() {
        System.out.println(ans);
    }

    private static void initialize() {
        ans = 0;
    }
}

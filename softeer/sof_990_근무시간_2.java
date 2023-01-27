package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.StringTokenizer;

public class sof_990_근무시간_2 {
    private static LocalTime ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        initialize();

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " :");

            int H1 = Integer.parseInt(st.nextToken());
            int M1 = Integer.parseInt(st.nextToken());
            int H2 = Integer.parseInt(st.nextToken());
            int M2 = Integer.parseInt(st.nextToken());

            LocalTime endTime = LocalTime.of(H2, M2);
            LocalTime startTime = LocalTime.of(H1, M1);

            ans.plusHours(endTime.getHour() - startTime.getHour())
                    .plusMinutes(endTime.getHour() - startTime.getHour());
        }

        print(ans.getHour() * 60 + ans.getMinute());
    }

    private static void print(int minutes) {
        System.out.println(minutes);
    }

    private static void initialize() {
        ans = LocalTime.of(0, 0);
    }
}

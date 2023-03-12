package programmers;

import java.time.Duration;
import java.time.LocalTime;
import java.util.StringTokenizer;

public class P17683 {
    private String[][] musicArr;

    public String solution(String m, String[] musicinfos) {
        musicArr = new String[musicinfos.length][3];

        for (int i = 0; i < musicinfos.length; i++) {
            StringTokenizer st = new StringTokenizer(musicinfos[i], ",");

            LocalTime startTime = LocalTime.parse(st.nextToken());
            LocalTime endTime = LocalTime.parse(st.nextToken());
            long minutes = Duration.between(startTime, endTime).toMinutes();

            String name = st.nextToken();

            String str = toMyMusic(st.nextToken());
            int len = str.length();

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < minutes; j++) {
                sb.append(str.charAt(j % len));
            }

            musicArr[i][0] = name;
            musicArr[i][1] = sb.toString();
            musicArr[i][2] = String.valueOf(minutes);
        }

        m = toMyMusic(m);

        String ans = "(None)";
        int minute = 0;

        for (String[] music : musicArr) {
            if (music[1].contains(m) && Integer.parseInt(music[2]) > minute) {
                ans = music[0];
                minute = Integer.parseInt(music[2]);
            }
        }

        return ans;
    }

    private String toMyMusic(String str) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < str.length(); j++) {
            char ch = Character.toLowerCase(str.charAt(j));

            if (j + 1 < str.length() && str.charAt(j + 1) == '#') {
                ch = Character.toUpperCase(ch);
                j++;
            }

            sb.append(ch);
        }
        return sb.toString();
    }
}

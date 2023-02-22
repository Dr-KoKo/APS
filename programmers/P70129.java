package programmers;

public class P70129 {

    public int[] solution(String s) {

        int cnt_zero = 0;
        int cnt = 0;

        while (!"1".equals(s)) {
            cnt_zero += s.chars().filter(x -> x == '0').count();
            s = Integer.toBinaryString(s.replace("0", "").length());
            ++cnt;
        }

        return new int[]{cnt, cnt_zero};

    }

}

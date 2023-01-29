package programmers;

public class P87946 {
    private static int N;
    private static int ans;
    private static int[][] dungeons;
    private static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        initialize(dungeons);

        rec(0, k, 0);

        return ans;
    }

    private void initialize(int[][] dungeons) {
        this.dungeons = dungeons;
        this.N = dungeons.length;
        visited = new boolean[N];
        ans = 0;
    }

    private void rec(int idx, int value, int ret) {
        if (idx == N) {
            ans = Math.max(ans, ret);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i])
                continue;

            if (dungeons[i][0] <= value) {
                visited[i] = true;

                rec(idx + 1, value - dungeons[i][1], ret + 1);

                visited[i] = false;
            } else {
                ans = Math.max(ans, ret);
            }

        }
    }
}

package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 욕심쟁이 판다
public class BOJ1937 {

    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] dp;
    static int[][] map;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(dfs(i, j), answer);
            }
        }
        System.out.println(answer);
    }

    private static int dfs(int a, int b) {
        if (dp[a][b] != 0) {
            return dp[a][b];
        }
        dp[a][b] = 1;

        int curr = map[a][b];
        for (int d = 0; d < 4; d++) {
            int nx = a + dx[d];
            int ny = b + dy[d];
            if (nx < 0|| nx >= n || ny < 0 || ny >= n) continue;

            if (curr < map[nx][ny]) {
                dp[a][b] = Math.max(dp[a][b], 1 + dfs(nx, ny));
            }
        }
        return dp[a][b];
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [모의 SW 역량테스트] 디저트 카페
public class SWEA2105 {

    // 우하, 좌하, 좌상, 우상
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};

    static int[][] map;
    static boolean[][] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            int max = Integer.MIN_VALUE;
            int cnt;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j])
                        cnt = dfs(i, j, 1);
                }
            }






        }

    }

    private static int dfs(int x, int y, int d) {

        if (d >= 4)
            return 0;

        visited[x][y] = true;

        int nx = x + dx[d];
        int ny = y + dy[d];

        if (nx < 0 || nx >= n || ny < 0 || ny >= n)
            d += 1;

        dfs(nx, ny, d);
        visited[nx][ny] = false;


    }

}

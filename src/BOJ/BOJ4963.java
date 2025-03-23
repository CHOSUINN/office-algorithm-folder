package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 각 섬에 도착할때마다 연결되어 있는 모든 섬을 방문하면서 방문 표시를 해준다.
 * 위 행동의 개수를 센다.
 */
// 섬의 개수
public class BOJ4963 {

    // 상하좌우 대각 4개
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int w;
    static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == h && w == 0)
                break;

            int[][] map = new int[h][w];
            boolean[][] visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(map, visited, i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);

    }

    // 연결된 땅 모두 visited표시해주기
    private static void bfs(int[][] map, boolean[][] visited, int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[i][j] = true;
        q.offer(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];

            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < h && ny >= 0 && ny < w && !visited[nx][ny] && map[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }

            }
        }

    }
}

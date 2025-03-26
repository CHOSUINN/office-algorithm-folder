import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// [모의 SW 역량테스트] 탈주범 검거
public class SWEA1953 {

    // 1번의 경우 상하좌우
    static int[] dxOne = {-1, 1, 0, 0};
    static int[] dyOne = {0, 0, -1, 1};

    // 2번의 경우 상하
    static int[] dxTwo = {-1, 1};
    static int[] dyTwo = {0, 0};

    // 3번의 경우 좌우
    static int[] dxThree = {0, 0};
    static int[] dyThree = {-1, 1};

    // 4번의 경우 상우
    static int[] dxFour = {-1, 0};
    static int[] dyFour = {0, 1};

    // 5번의 경우 우하
    static int[] dxFive = {0, 1};
    static int[] dyFive = {1, 0};

    // 6번의 경우 좌하
    static int[] dxSix = {0, 1};
    static int[] dySix = {-1, 0};

    // 7번의 경우 상좌
    static int[] dxSeven = {-1, 0};
    static int[] dySeven = {0, -1};

    static int[][] map;
    static boolean[][] visited;
    static int n, m, r, c, l;
    static int answer;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/foolsCap.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(st.nextToken()); // 세로 길이
            m = Integer.parseInt(st.nextToken()); // 가로 길이
            r = Integer.parseInt(st.nextToken()); // 탈출 세로 좌표
            c = Integer.parseInt(st.nextToken()); // 탈출 가로 길이
            l = Integer.parseInt(st.nextToken()); // 탈출 후 경과시간

            map = new int[n][m];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < m; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            // 시작 좌표 [r][c];
            visited = new boolean[n][m];
            answer = 0;
            bfs(r, c, l);

            sb.append("#").append(t + 1).append(" ").append(answer);
            System.out.println(sb);
            sb.setLength(0);
        }

    }

    private static void bfs(int r, int c, int l) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c, 1});
        int len = q.size();

        while (!q.isEmpty()) {
            for (int i = 0; i < len; i++) {
                int[] temp = q.poll();
                int a = temp[0];
                int b = temp[1];
                int cnt = temp[2];
                visited[a][b] = true;
                if (cnt == l) {
                    answer++;
                    continue;
                }

                int currRoad = map[a][b];
                if (currRoad == 1) {
                    for (int d = 0; d < 4; d++) {
                        int nr = a + dxOne[d];
                        int nc = b + dyOne[d];

                        if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                        if (visited[nr][nc]) continue;
                        if (map[nr][nc] == 0) continue;
                        if (d == 0 && (map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 7))
                            continue;
                        if (d == 1 && (map[nr][nc] == 3 || map[nr][nc] == 5 || map[nr][nc] == 6))
                            continue;
                        if (d == 2 && (map[nr][nc] == 2 || map[nr][nc] == 6 || map[nr][nc] == 7))
                            continue;
                        if (d == 3 && (map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 5))
                            continue;

                        q.offer(new int[]{nr, nc, cnt + 1});
                    }


                } else if (currRoad == 2) {
                    for (int d = 0; d < 2; d++) {
                        int nr = a + dxTwo[d];
                        int nc = b + dyTwo[d];

                        if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                        if (map[nr][nc] == 0) continue;
                        if (visited[nr][nc]) continue;
                        if (d == 0 && (map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 8))
                            continue;
                        if (d == 1 && (map[nr][nc] == 3 || map[nr][nc] == 5 || map[nr][nc] == 6))
                            continue;

                        q.offer(new int[]{nr, nc, cnt + 1});

                    }

                } else if (currRoad == 3) {
                    for (int d = 0; d < 2; d++) {
                        int nr = a + dxThree[d];
                        int nc = b + dyThree[d];

                        if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                        if (map[nr][nc] == 0) continue;
                        if (visited[nr][nc]) continue;
                        if (d == 0 && (map[nr][nc] == 2 || map[nr][nc] == 6 || map[nr][nc] == 7))
                            continue;
                        if (d == 1 && (map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 5))
                            continue;

                        q.offer(new int[]{nr, nc, cnt + 1});

                    }

                } else if (currRoad == 4) {
                    for (int d = 0; d < 2; d++) {
                        int nr = a + dxFour[d];
                        int nc = b + dyFour[d];

                        if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                        if (map[nr][nc] == 0) continue;
                        if (visited[nr][nc]) continue;
                        if (d == 0 && (map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 7))
                            continue;
                        if (d == 1 && (map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 5))
                            continue;

                        q.offer(new int[]{nr, nc, cnt + 1});

                    }

                } else if (currRoad == 5) {
                    for (int d = 0; d < 2; d++) {
                        int nr = a + dxFive[d];
                        int nc = b + dyFive[d];

                        if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                        if (map[nr][nc] == 0) continue;
                        if (visited[nr][nc]) continue;
                        if (d == 0 && (map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 5))
                            continue;
                        if (d == 1 && (map[nr][nc] == 3 || map[nr][nc] == 5 || map[nr][nc] == 6))
                            continue;

                        q.offer(new int[]{nr, nc, cnt + 1});

                    }


                } else if (currRoad == 6) {
                    for (int d = 0; d < 2; d++) {
                        int nr = a + dxSix[d];
                        int nc = b + dySix[d];

                        if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                        if (map[nr][nc] == 0) continue;
                        if (visited[nr][nc]) continue;
                        if (d == 0 && (map[nr][nc] == 2 || map[nr][nc] == 6 || map[nr][nc] == 7))
                            continue;
                        if (d == 1 && (map[nr][nc] == 3 || map[nr][nc] == 5 || map[nr][nc] == 6))
                            continue;

                        q.offer(new int[]{nr, nc, cnt + 1});

                    }

                } else if (currRoad == 7) {
                    for (int d = 0; d < 2; d++) {
                        int nr = a + dxSeven[d];
                        int nc = b + dySeven[d];

                        if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                        if (map[nr][nc] == 0) continue;
                        if (visited[nr][nc]) continue;
                        if (d == 0 && (map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 7))
                            continue;
                        if (d == 1 && (map[nr][nc] == 2 || map[nr][nc] == 6 || map[nr][nc] == 7))
                            continue;

                        q.offer(new int[]{nr, nc, cnt + 1});

                    }
                }
            }
        }
    }
}

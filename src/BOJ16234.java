import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 인구 이동
public class BOJ16234 {

    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n;
    static int l;
    static int r;
    static boolean[][] visited;
    static int[][] map;
    static int total = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {


                for (int ii = 0; ii < n; ii++) {
                    for (int jj = 0; jj < n; jj++) {
                        // 연합의 칸 세기.
                        total = 0;
                        cnt = 0;
                        if (!visited[ii][jj]) {
                            // bfs하러 들어갔을때, 어디에도 인구이동을 하지 않는 경우 false반환
                            boolean moved = checkPopulation(ii, jj);

                            // 만약 인구이동이 일어났을 경우
                            if (moved) {
                                // 인구 이동 시킨 값 적용
                                int temp = total / cnt;
                                for (int iii = 0; iii < n; iii++) {
                                    for (int jjj = 0; jjj < n; jjj++) {
                                        if (visited[iii][jjj])
                                            map[iii][jjj] = temp;
                                    }
                                }

                                for (int x = 0; x < n; x++) {
                                    for (int y = 0; y < n; y++) {
                                        System.out.print(map[x][y] + " ");
                                    }
                                    System.out.println();
                                }
                                System.out.println("---------------");
                                answer++;
                            }
                        }


                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean checkPopulation(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited = new boolean[n][n];

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int a = temp[0];
            int b = temp[1];
            visited[a][b] = true;
            total += map[a][b];
            cnt += 1;

            for (int d = 0; d < 4; d++) {
                int na = a + dx[d];
                int nb = b + dy[d];

                if (na < 0 || na >= n || nb < 0 || nb >= n || visited[na][nb]) continue;

                int diff = Math.abs(map[a][b] - map[na][nb]);
                if (l > diff || r < diff) continue;

                q.offer(new int[]{na, nb});
            }
        }
        return cnt != 1;
    }
}

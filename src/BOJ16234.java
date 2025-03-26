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
    static List<int[]> alliance = new ArrayList<>();

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

        // 완전 탐색으로 돌면서, 델타 탐색으로 경계를 허물것임.
        // 단 visited를 통해 중복으로 벽을 허물지 않도록 할것임.
        // 한번 칸을 허물러 들어갔다 나올때마다 각 칸의 값을 재정의 해준다. (연합 인구의 수)/칸의 개수
        // List<int[]> 에 각 계산해야하는 연합의 총 인구수와, 칸의 개수를 int[]에 담아서 넣어준다.
        // List.size()가 정답!
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (population(i, j) > 1)
                        answer++;
                    else
                        visited[i][j] = false;
                }
            }
        }

        System.out.println(answer);
    }

    private static int population(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int a = temp[0];
            int b = temp[1];
            visited[a][b] = true;

            for (int d = 0; d < 4; d++) {
                int na = a + dx[d];
                int nb = b + dy[d];

                if (na < 0 || na >= n || nb < 0 || nb >= n || visited[na][nb]) continue;

                int diff = Math.abs(map[a][b] - map[na][nb]);
                if (l > diff || r < diff) continue;

                q.offer(new int[]{na, nb});
                cnt++;
            }
        }
        return cnt;
    }
}

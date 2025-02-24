package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

// 미로 탐색
public class BOJ2178 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] arr;

    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(sc.nextLine());
            String input = st.nextToken();
            int index = 0;
            for (int j = 1; j <= m; j++)
                arr[i][j] = Integer.parseInt(String.valueOf(input.charAt(index++)));
        }

        int answer = bfs(1,1);

        System.out.println(answer);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            if (r == n && c == m)
                return arr[r][c];

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (nr < 1 || nr > n || nc < 1 || nc > m) continue;

                if (arr[nr][nc] == 1) {
                    q.offer(new int[]{nr, nc});
                    arr[nr][nc] = arr[r][c] + 1;
                }
            }
        }
        return arr[n][m];
    }
}

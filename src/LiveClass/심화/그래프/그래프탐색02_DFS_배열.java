package LiveClass.심화.그래프;

import java.util.Scanner;

public class 그래프탐색02_DFS_배열 {
    static int n;  // n * n, n * m일수도 있다. 지금은 n * n으로 가정하자.
    static int[][] map;  // 2차원 배열
    static boolean[][] visited;
    static boolean ans = false;

    // 4방향
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        // 현재는 (0, 0) -> (n - 1,  n - 1) 갈 수 있는지 확인 하는 중이다. 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
//                if (map[i][j] == 2) {
                    // 출발지 혹은 도착지를 저장할수도 있음
//                }
            }

        }

        dfs(0, 0);
    }

    // r : 행, c: 열
    private static void dfs(int r, int c) {
        // 종료조건
        if (r == n - 1 && c == n - 1) {
            ans = true;
            return;
        }

        visited[r][c] = true;
        
        // 재귀부분
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 범위를 벗어나면 탈출
            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
            // 벽이면 탈출
            if (map[nr][nc] == 1) continue;
            // 방문했던 곳이면 탈출
            if (visited[nr][nc]) continue;

            dfs(nr, nc);

        }

    }

}

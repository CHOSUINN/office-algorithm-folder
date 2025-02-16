import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 수영대회 결승전
public class SWEA4193 {

    static Queue<int[]> queue;
    static int time = 0;
    static boolean[][] visited;
    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());

        int[][] swim = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                swim[i][j] = Integer.parseInt(sc.next());

        int startX = Integer.parseInt(sc.next());
        int startY = Integer.parseInt(sc.next());

        int endX = Integer.parseInt(sc.next());
        int endY = Integer.parseInt(sc.next());

        bfs(startX, startY, endX, endY, n);

    }

    private static void bfs(int startX, int startY, int endX, int endY, int n) {
        queue = new LinkedList<>();
        queue.offer(new int[] {startX, startY});

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                for (int k = 0; k < 4; k++) {
                    int nx = startX + dx[k];
                    int ny = startY + dy[k];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (visited[nx][ny] == true) continue;
                    queue.offer(new int[]{nx, ny});
                }

                time++;
            }

        }




    }
}

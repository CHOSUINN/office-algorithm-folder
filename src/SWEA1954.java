import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 달팽이 숫자
public class SWEA1954 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/foolsCap.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            sb.append("#").append(t + 1).append("\n");
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];
            boolean[][] visited = new boolean[n][n];
            int dir = 0;
            int x = 0, y = 0;
            for (int i = 1; i <= n * n; i++) {
                arr[x][y] = i;
                visited[x][y] = true;

                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
                    dir = (dir + 1) % 4;
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }

                x = nx;
                y = ny;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(arr[i][j] + " ");
                }
                sb.append("\n");
            }

            System.out.print(sb);
            sb.setLength(0);

        }

    }
}

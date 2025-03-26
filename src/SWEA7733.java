import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 치즈 도둑
public class SWEA7733 {

    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] cheeze;
    static boolean[][] visited;
    static int n;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/foolsCap.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());

            cheeze = new int[n][n];
            int maxDay = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    cheeze[i][j] = Integer.parseInt(st.nextToken());
                    if (maxDay < cheeze[i][j])
                        maxDay = cheeze[i][j];
                }
            }

            // 1~100일까지, 먹고 세고, 최대값 갱신해주어야한다.

            int day = 1;
            int cheezeGroups = 1;
            while (day <= maxDay) {
                visited = new boolean[n][n];

                // 먹기
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (cheeze[i][j] == day)
                            cheeze[i][j] = 0;
                    }
                }

                // 세기
                int cnt = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (cheeze[i][j] != 0 && !visited[i][j]) {
                            dfs(i, j);
                            cnt++;
                        }

                    }
                }

//                출력테스트
//                for (int i = 0; i < n; i++) {
//                    for (int j = 0; j < n; j++) {
//                        System.out.print(cheeze[i][j] + " ");
//                    }
//                    System.out.println();
//                }
//                System.out.println("--------------");
//                System.out.println(answer);
//                System.out.println("--------------");

                // 최대값 갱신
                if (cnt > cheezeGroups)
                    cheezeGroups = cnt;

                day++;
            }

            sb.append("#").append(t + 1).append(" ").append(cheezeGroups);
            System.out.println(sb);
            sb.setLength(0);
        }

    }

    private static void dfs(int x, int y) {

        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (visited[nx][ny]) continue;
            if (cheeze[nx][ny] == 0) continue;

            dfs(nx, ny);
        }
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] map;
    static boolean[][] visited;
    static List<int[]> maxHeight;
    static int n, k;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 9; t < tc; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            maxHeight = new ArrayList<>(); // 최대 높이의 기둥들의 위치 모음

            // map 입력값 처리하면서 최대 높이의 기둥들의 좌표 저장해두기.
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] > max) {
                        max = map[i][j];
                        maxHeight.clear();
                        maxHeight.add(new int[]{i, j});
                    } else if (map[i][j] == max)
                        maxHeight.add(new int[]{i, j});
                }
            }

            answer = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int dig = 0; dig <= k; dig++) {

                        map[i][j] -= dig;
                        for (int p = 0; p < maxHeight.size(); p++) {
                            visited = new boolean[n][n];
                            bfs(maxHeight.get(p));
                        }
                        map[i][j] += dig;
                    }
                }
            }

            sb.append("#").append(t + 1).append(" ").append(answer);
            System.out.println(sb);
            sb.setLength(0);
        }
    }

    private static void bfs(int[] start) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start[0], start[1], 1});
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = temp[0] + dx[d];
                int ny = temp[1] + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] >= map[temp[0]][temp[1]]) continue;

                q.offer(new int[]{nx, ny, temp[2] + 1});
                visited[nx][ny] = true;
                answer = Math.max(answer, temp[2] + 1);
            }

        }
    }

}
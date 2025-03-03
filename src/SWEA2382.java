import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 미생물 격리
public class SWEA2382 {

    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int[][][] map;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/foolsCap.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());  // 셀의 개수
            int m = Integer.parseInt(st.nextToken());  // 격리 시간
            int k = Integer.parseInt(st.nextToken());  // 미생물 군집의 개수

            // map[x][y][0] == 군집 크기
            // map[x][y][1] == 방향
            // map[x][y][2] == 최대값
            map = new int[n][n][3];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int microOrganism = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;

                map[x][y][0] = microOrganism;
                map[x][y][1] = dir;
                map[x][y][2] = microOrganism;
            }

            for (int cnt = 0; cnt < m; cnt++) {
//                printMap(map, n);
                moveMap();
            }


            int answer = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j][0] != 0) {
                        answer += map[i][j][0];
                    }
                }
            }

            sb.append("#").append(t + 1).append(" ").append(answer);
            System.out.println(sb);
            sb.setLength(0);
        }
    }

    private static void moveMap(){
        int[][][] newMap = new int[n][n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j][0] != 0) {
                    int x = i;
                    int y = j;
                    int size = map[i][j][0];
                    int dir = map[i][j][1];
                    int maxSize = map[i][j][2];
                    if (size == 0) continue;

                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx <= 0 || nx >= n - 1 || ny <= 0 || ny >= n - 1) {
                        size /= 2;
                        dir = switchDir(dir);
                    }

                    // 이미 군집이 존재하면
                    if (newMap[nx][ny][0] != 0) {
                        if (newMap[nx][ny][2] < maxSize) {
                            newMap[nx][ny][1] = dir;
                            newMap[nx][ny][2] = maxSize;
                        }
                        newMap[nx][ny][0] += size;
                    } else {
                        // 군집이 존재하지 않아.
                        newMap[nx][ny][0] = size;
                        newMap[nx][ny][1] = dir;
                        newMap[nx][ny][2] = maxSize;
                    }
                }
            }
        }

        // 군집별 최대값 갱신
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (newMap[i][j][0] != 0) {
                    newMap[i][j][2] = newMap[i][j][0];
                }
            }
        }

        //map갱신
        map = newMap;
    }

    private static int switchDir(int dir) {
        switch (dir) {
            case 0:
                dir = 1;
                break;
            case 1:
                dir = 0;
                break;
            case 2:
                dir = 3;
                break;
            case 3:
                dir = 2;
                break;
        }
        return dir;
    }


    private static void printMap(int[][][] map, int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j][0] + " ");
            }
            System.out.println();
        }
        System.out.println("===");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j][2] + " ");
            }
            System.out.println();
        }
        System.out.println("===");

    }
}
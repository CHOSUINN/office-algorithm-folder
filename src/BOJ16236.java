import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 아기 상어
public class BOJ16236 {

    static final int BABY_SHARK_SIZE_INIT = 2;
    static final int NUMBER_OF_FISHES = 7;
    static int numberOfGrowth = 0;

    // 좌우상하 - 가까운 물고기가 여럿일경우 가장 왼쪽에 있는 물고기를 먹어야하기 때문에, 좌를 최우선으로 해주고 나머지는 그냥 설정해준다.
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
//    static boolean[][] visited;
    static int n;

    // 아기 상어의 위치
    static int[] babySharkLocation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 아기 상어 크기와 섭취한 물고기의 수
        int babySharkSize = BABY_SHARK_SIZE_INIT;
        int fishConsumed = 0;

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        // 아기 상어 위치
        babySharkLocation = new int[2];
        // 1~6 생선들의 개수
        int[] fishArr = new int[NUMBER_OF_FISHES];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 아기 상어 좌표 파악
                if (map[i][j] == 9) {
                    babySharkLocation[0] = i;
                    babySharkLocation[1] = j;

                    // 1~6부터 생선들의 개수를 fishArr에 저장
                } else if (map[i][j] != 0)
                    fishArr[map[i][j]]++;
            }
        }

        int answer = 0;
        boolean flag = false;
        for (int i = 1; i < NUMBER_OF_FISHES; i++) {
            // 섭취해야하는 생선의 개수보다 적으면 먹고 나가기
            if (fishArr[i] < babySharkSize) {
                flag = true;
                break;
            }

            // 섭취해야하는 생선의 개수가 충분하면, 아기상어의 크기만큼 섭취
            for (int j = 0; j < babySharkSize; j++) {
                boolean[][] visited = new boolean[n][n];
                moveBabyShark(babySharkLocation, visited);
            }
        }

    }

    // 해당 위치까지 최소시간.
    private static void moveBabyShark(int[] babySharkLocation, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        int x = babySharkLocation[0];
        int y = babySharkLocation[1];
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n) continue;
                if (ny < 0 || ny >= n) continue;

                q.offer(new int[]{nx, ny});
            }


        }


    }
}

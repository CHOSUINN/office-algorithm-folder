import java.util.Scanner;

// 오셀로 게임
public class Test1 {

    // 상하좌우대각네개
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[][] board;
    static int boardLen;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        for (int t = 0; t < testCase; t++) {

            int n = sc.nextInt();
            boardLen = n;
            int m = sc.nextInt();
            board = new int[n + 1][n + 1];

            //오셀로 초기 세팅
            int mid = n / 2;
            board[mid][mid] = 2;
            board[mid + 1][mid + 1] = 2;
            board[mid][mid + 1] = 1;
            board[mid + 1][mid] = 1;

            // 돌을 놓는 횟수.
            for (int i = 0; i < m; i++) {
                int y = sc.nextInt();
                int x = sc.nextInt();
                int c = sc.nextInt();

                board[x][y] = c;

                turnStoneColour(x, y, c);

//                // 보드 출력
//                System.out.println(y + " " + x + " " + c);
//                System.out.println("========");
//                for (int k = 1; k <= boardLen; k++) {
//                    for (int p = 1; p <= boardLen; p++) {
//                        System.out.printf("%d ", board[k][p]);
//                    }
//                    System.out.println();
//                }
//                System.out.println("========");
            }

            int black = 0;
            int white = 0;
            // 돌 숫자 세기
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (board[i][j] == 1)
                        black++;
                    if (board[i][j] == 2)
                        white++;
                }
            }
            
            // 출력
            System.out.printf("#%d %d %d\n", t + 1, black, white);

        }
    }

    // 오셀로 돌 돌리기
    private static void turnStoneColour(int x, int y, int c) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 상하좌우대각 상대방 돌이 아니면 continue
            if (!(nx >= 1 && nx <= boardLen && ny >= 1 && ny <= boardLen)) continue;
            if (board[nx][ny] == 0) continue;
            if (board[nx][ny] == c) continue;

            int a = nx;
            int b = ny;

            // 나랑 같은 색 돌이 나올때까지 나아가보기.
            // 만약 나랑 같은 색 돌이 나오면 flag=true 그게 아니면 false로 둠
            boolean flag = false;
            while (a >= 1 && a <= boardLen && b >= 1 && b <= boardLen) {
                if (board[a][b] == c) {
                    flag = true;
                    break;
                } else if (board[a][b] == 0) break;
                a += dx[i];
                b += dy[i];
            }

            int tempx = nx;
            int tempy = ny;
            
            // 나랑 같은 색 돌이 나왔으면
            // 해당 인덱스까지 돌의 색 바꾸기
            if (flag) {
                while (board[tempx][tempy] != c) {
                    board[tempx][tempy] = c;
                    tempx += dx[i];
                    tempy += dy[i];
                }
            }

        }

    }
}

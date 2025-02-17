//import java.util.*;
//
//
//// 오셀로
//public class Solution {
//
//    // 돌을 놓을 곳이 없으면 상대방차례가 됨
//    // 빈곳이 없거나 서로 놓을 곳 없으면 게임 종료
//    // 자신이 놓을 돌과 자신의 돌 사이에 상대편 돌이 있을 때만 놓을 수 있음 => 그다음 내 돌이 됨
//    // 1흑돌 2백돌
//
//    // 방향정하고 쭉나가면서 내색이랑 같은거나올때까지 좌표저장했다가 한방에 바꾸기기
//
//    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
//    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        StringBuffer sb = new StringBuffer();
//        int T = sc.nextInt();
//
//        for (int t = 1; t <= T; t++) {
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            int[][] board = new int[n][n];
//            int i = n / 2 - 1;
//            int j = n / 2 - 1;
//            board[i][j] = 2;
//            board[i+1][j] = 1;
//            board[i][j+1] = 1;
//            board[i+1][j+1] = 2;
//
//            while (m-- > 0) {
//                int y = sc.nextInt() - 1;
//                int x = sc.nextInt() - 1;
//                int dol = sc.nextInt();
//                board[x][y] = dol;
//
//                for (int dir = 0; dir < 8; dir++) {
//                    List<int[]> list = new ArrayList<>();
//                    int k = 0;
//                    while (++k < 20) {
//                        int nx = x + k * dx[dir];
//                        int ny = y + k * dy[dir];
//                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
//                            list.clear();
//                            break;
//                        }
//                        if (board[nx][ny] == 0) {
//                            list.clear();
//                            break;
//                        }
//                        if (board[nx][ny] == dol) {
//                            break;
//                        } else {
//                            list.add(new int[]{nx, ny});
//                        }
//                    }
//                    for (int[] e: list) {
//                        board[e[0]][e[1]] = dol;
//                    }
//                }
//
//            }
//
//            int cnt1 = 0, cnt2 = 0;
//            for (int ii = 0; ii < n; ii++) {
//                for (int jj = 0; jj < n; jj++) {
//                    if (board[ii][jj] == 1) cnt1++;
//                    if (board[ii][jj] == 2) cnt2++;
//                }
//            }
//
//            sb.append('#');
//            sb.append(t);
//            sb.append(' ');
//            sb.append(cnt1);
//            sb.append(' ');
//            sb.append(cnt2);
//            sb.append('\n');
//        }
//        System.out.println(sb);
//    }
//}
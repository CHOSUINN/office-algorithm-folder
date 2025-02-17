package SWEA;

import java.util.Scanner;

// 오목 판정
public class SWEA11315 {

    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < tc; t++) {
            sb.append("#").append(t + 1).append(" ");

            int n = Integer.parseInt(sc.nextLine());
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                char[] str = sc.nextLine().toCharArray();
                for (int j = 0; j < n; j++) {
                    board[i][j] = str[j];
                }
            }

            boolean flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (board[i][j] == 'o') {
                        for (int k = 0; k < 8; k++) {

                            int cnt = 1;
                            while (true) {
                                int nx = i + dx[k] * cnt;
                                int ny = j + dy[k] * cnt;
                                if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;
                                if (board[nx][ny] != 'o')
                                    break;
                                else if (board[nx][ny] == 'o')
                                    cnt++;
                            }
                            if (cnt >= 5) {
                                sb.append("YES");
                                flag = true;
                                break;
                            }
                        }
                    }
                    if (flag) break;
                }
                if (flag) break;
            }


            if (!flag) sb.append("NO");
            System.out.println(sb);
            sb.setLength(0);
        }

    }
}

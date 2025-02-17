import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA11315 {

    static int dx[] = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int dy[] = {0, 0, -1, 1, -1, 1, 1, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();

        int tc = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < tc; t++) {

            int n = Integer.parseInt(sc.nextLine());
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                char[] str = sc.nextLine().toCharArray();
                for (int j = 0; j < n; j++) {
                    board[i][j] = str[j];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    for (int k = 0; k < 8; k++) {

                        while (true) {

                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx < 0 || nx >n || ny < 0 || ny > n) break;
                            if (board[nx][ny] != 'o') break;
                        }

                    }
                }
            }


            // 출력 테스트
//            for (char[] chars : board) {
//                for (char aChar : chars) {
//                    System.out.print(aChar + " ");
//                }
//                System.out.println();
//            }


        }

    }
}

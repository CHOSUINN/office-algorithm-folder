package SWEA;

import java.util.Scanner;

public class SWEA1210 {

    // 좌우상 3방향.
    static int[] dr = {0, 0, -1};
    static int[] dc = {-1, 1, 0};

    // Ladder 1
    public static void main(String[] args) {

        // 초기값 설정 및 입력값 받기
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[100][100];

        for (int k = 0; k < 10; k++) {

            int t = sc.nextInt();

            // 입력값 넣기
            for (int i = 0; i < 100; i++)
                for (int j = 0; j < 100; j++) 
                    arr[i][j] = sc.nextInt();

            // 당첨 위치부터 시작.
            // 만약 당첨 위치부터 시작하지 않으면 모든 사다리의 출발위치에서부터
            // 도달위치를 확인해보면서 2에서 끝나는지 확인해야함.
            int index = 0;
            for (int i = 0; i < 100; i++) {
                if (arr[99][i] == 2) {
                    index = i;
                    break;
                }
            }

            // 좌표
            // r = 99;
            // c = index; 에서 시작.

            int r = 99;
            int c = index;

            while (r != 0) {

                // 시작 위치에서부터 3방향 검색
                for (int i = 0; i < 3; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (nr < 0 || nr >= 100 || nc < 0 || nc >= 100) continue;
                    if (arr[nr][nc] != 1) continue;

                    arr[r][c] = -1;
                    r = nr;
                    c = nc;
                }
            }
            System.out.printf("#%d %d\n", t, c);

        }


    }
}

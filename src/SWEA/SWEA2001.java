package SWEA;

import java.util.Scanner;

public class SWEA2001 {

    // 파리퇴치
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int n, m;
        int[][] arr;
        int answer;

        for (int testCase = 0; testCase < t; testCase++) {

            // 값 초기화 및 할당
            n = sc.nextInt();
            m = sc.nextInt();
            arr = new int[n][n];
            answer = 0;

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();


            // 배열을 돌면서 최대 파리퇴치 값 찾기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    int cnt = 0;
                    // 현재 위치부터 m크기의 파래퇴치 값 찾기
                    for (int x = 0; x < m; x++) {
                        int ni = i + x;

                        // 배열 인덱스 벗어나는지 확인
                        if (ni < 0 || ni >= n) continue;

                        for (int y = 0; y < m; y++) {
                            int nj = j + y;

                            if (nj < 0 || nj >= n) continue;

                            cnt += arr[ni][nj];
                        }
                    }
                    if (cnt > answer)
                        answer = cnt;
                }
            }


            System.out.printf("#%d %d\n", testCase + 1, answer);
        }
    }
}

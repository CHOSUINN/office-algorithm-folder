package SWEA;

import java.util.Scanner;

public class SWEA1954 {
    
    // 달팽이 숫자
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[][] arr;

        for (int testCase = 0; testCase < t; testCase++) {

            int n = sc.nextInt();
            arr = new int[n][n];
            int digit = 1;
            int r = 0;
            int c = -1;
            int k = n;
            int dir = 1;

            while (true) {

                for (int i = 0; i < k; i++) {
                    c += dir;
                    arr[r][c] = digit++;
                }
                k--;

                for (int i = 0; i < k; i++) {
                    r += dir;
                    arr[r][c] = digit++;
                }

                // 방향 전환
                dir = dir * (-1);

                if (k == 0) break;

            }

            System.out.printf("#%d\n", testCase + 1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%d ",arr[i][j]);
                }
                System.out.println();
            }
        }
    }
}

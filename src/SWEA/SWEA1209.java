package SWEA;

import java.util.Scanner;

public class SWEA1209 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max;
        int[][] arr = new int[100][100];

        for (int t = 0; t < 10; t++) {

            max = Integer.MIN_VALUE;
            int n = sc.nextInt();

            for (int i = 0; i < 100; i++)
                for (int j = 0; j < 100; j++)
                    arr[i][j] = sc.nextInt();

            int sum3 = 0;
            int sum4 = 0;
            for (int i = 0; i < 100; i++) {
                int sum1 = 0;
                int sum2 = 0;

                // 행의 합 구하기
                for (int j = 0; j < 100; j++)
                    sum1 += arr[i][j];

                // 열의 합 구하기
                for (int j = 0; j < 100; j++)
                    sum2 += arr[j][i];

                max = Math.max(max, Math.max(sum1, sum2));

                // 좌에서 우 대각선
                sum3 += arr[i][i];

                // 우에서 좌 대각선
                sum4 += arr[i][100 - 1 - i];
            }

            max = Math.max(max, Math.max(sum3, sum4));

            System.out.printf("#%d %d\n", n, max);
        }
    }
}


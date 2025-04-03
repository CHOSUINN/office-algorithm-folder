package LiveClass.심화.동적계획법_DP;

import java.util.Scanner;

// 0-1 Knapsack
public class 동적계획법03_배낭문제 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 물건의 개수
        int W = sc.nextInt(); // 배낭의 무게

        // 무게와 값어치 -> 2차원 배열 입력 / 1차원 2개
        int[] cost = new int[N + 1];
        int[] weights = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            cost[i] = sc.nextInt();
            weights[i] = sc.nextInt();
        }

        int[][] dp = new int[N + 1][W + 1]; // i번째 물건까지 w만큼 고려할거임

        // 물건은 한개씩만 존재
        for (int i = 1; i <= N; i++) {
            for (int w = 0; w <= W; w++) {
                // 1. 내가 고려할 물건의 무게가 임시 무게보다 작거나 같다면
                if (weights[i] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i]] + cost[i]);

                }
                // 2. 내가 고려할 물건의 무게가 임시무게보다 크다면
                // 배낭에 안들어갈 정도로 크다면
                else {
                    // 바로 직전의 행의 값을 그대로 가져온다.
                    dp[i][w] = dp[i - 1][w];
                }

            }
        }
        System.out.println(dp[N][W]);

    }
}

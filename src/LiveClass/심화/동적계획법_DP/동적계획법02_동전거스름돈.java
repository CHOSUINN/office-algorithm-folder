package LiveClass.심화.동적계획법_DP;

import java.util.Arrays;
import java.util.Scanner;

public class 동적계획법02_동전거스름돈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사용할 수 있는 동전은 1, 4, 6
        
        int money = sc.nextInt(); // 거스름돈을 입력받자
        int[] dp = new int[money + 1];

        for (int i = 1; i <= money; i++) {
            int minCnt = 987654321; // 임의의 큰 수
            
            // 1원을 고려했을때,
            minCnt = Math.min(minCnt, dp[i - 1] + 1);
            // 4원을 고려했을때,
            if (i >= 4)
                minCnt = Math.min(minCnt, dp[i - 4] + 1);
            if (i >= 6)
                minCnt = Math.min(minCnt, dp[i - 6] + 1);

            dp[i] = minCnt;
        }
        System.out.println(Arrays.toString(dp));


    }
}

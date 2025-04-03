package LiveClass.심화.동적계획법_DP;

import java.util.Arrays;
import java.util.Scanner;

public class 동적계획법01_피보나치 {

    static int[] memo2;
    // 초기화 블럭
    static {
        memo2 = new int[10000];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        memo = new int[500000 - 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;

        System.out.println(fibo1(10));
        System.out.println(fibo2(10));
        System.out.println(fibo3(3000));

        // n이 주어질수 있는 최대값으로 하나 구해놓고

        // 네케마다 계산을 해서 출력x
        for (int tc = 1; tc <= 10; tc++) {
            int k = sc.nextInt();
        }
    }

    // 단순 재귀는 중복호출이 존재한다
    static int fibo1(int n) {
        if (n <= 1) return n;
        return fibo1(n - 1) + fibo1(n - 2);
    }

    // 저장을 해두고 활용할거야 -> 새로운 추가 메모리 공간이 필요

    static int[] memo;

    static int fibo2(int n) {
        if (memo[n] == -1) {
            memo[n] = fibo2(n - 1) + fibo2(n - 2);
        }
        return memo[n];
    }

    static int fibo3(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

package BOJ;

import java.util.Scanner;

// 파도반 수열
public class BOJ9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < tc; t++) {
            long n = Long.parseLong(sc.nextLine());
            long[] dp = new long[(int) n + 1];
            dp[0] = 0;
            dp[1] = 1;
            if (n > 1)
                dp[2] = 1;

            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 2] + dp[i - 3];
            }
            System.out.println(dp[(int) n]);

        }
    }

}

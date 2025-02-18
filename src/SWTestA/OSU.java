package SWTestA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class OSU {

    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = input[0], p = input[1];
            int[] eat1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] eat2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[][] dp = new int[2][n];
            dp[0][0] = eat1[0];
            dp[1][0] = eat2[0];

            for (int i = 1; i < n; i++) {
                int add1 = eat1[i] - p;
                if (add1 < 0) add1 = 0;
                dp[0][i] = Math.max(dp[0][i-1] + add1, dp[1][i-1] + eat1[i]);

                int add2 = eat2[i] - p;
                if (add2 < 0) add2 = 0;
                dp[1][i] = Math.max(dp[1][i-1] + add2, dp[0][i-1] + eat2[i]);
            }

            int ans = Math.max(dp[0][n-1], dp[1][n-1]);

            sb.append('#');
            sb.append(tc);
            sb.append(' ');
            sb.append(ans);
            sb.append('\n');
        }
        System.out.println(sb);

    }
}
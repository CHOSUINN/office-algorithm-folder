package SWTestA;

import java.util.Scanner;

// 솔빈이
class LSB {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int t=1;t<=T;t++) {
            String[] input = sc.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int p = Integer.parseInt(input[0]);
            int[] a = new int[n];
            input = sc.nextLine().split(" ");
            for (int i=0;i<n;i++) {
                a[i] = Integer.parseInt(input[i]);
            }
            int[] b = new int[n];
            input = sc.nextLine().split(" ");
            for (int i=0;i<n;i++) {
                b[i] = Integer.parseInt(input[i]);
            }
            int[][] dp = new int[n][2];
            dp[0][0] = a[0];
            dp[0][1] = b[0];
            for (int i=1;i<n;i++) {
                dp[i][0] = Math.max(dp[i-1][0]+a[i]-p, dp[i-1][1]+a[i]);
                dp[i][1] = Math.max(dp[i-1][0]+b[i], dp[i-1][1]+b[i]-p);
            }
            int result = Math.max(dp[n-1][0], dp[n-1][1]);
            System.out.println("#"+t+" "+result);
        }
    }
}
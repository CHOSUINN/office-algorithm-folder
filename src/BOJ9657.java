import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9657 {

    static boolean[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        // true = SK, false = CY
        dp = new boolean[1001];
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        dp[4] = true;
        dp[5] = false;
        dp[6] = true;
        dp[7] = true;
        // 이전 두개가 t t 면 f, t, f면 t?

        for (int i = 8; i <= n; i++) {
            dp[i] = !(dp[i - 1] && dp[i - 2]);
            System.out.println(dp[i]);
        }

        sb.append(dp[n] ? "SK" : "CY");




//        boolean answer = dfs(n, true);
//
//        sb.append((answer) ? "SK" : "CY");
        System.out.println(sb);


    }

//    private static boolean dfs(int n, boolean flag) {
//
//        if (n == 1 || n == 3 || n == 4)
//            return flag;
//
//        else if (n < 0)
//            return flag;
//        else {
//            dfs(n - 1, !flag);
//
//            dfs(n - 3, !flag);
//
//            dfs (n - 4, !flag);
//        }
//        return flag;
//    }
}

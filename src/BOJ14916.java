import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 거스름 돈
public class BOJ14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //100_000
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[n + 4];

        dp[1] = -1;
        dp[2] = 1;
        dp[3] = -1;

        for (int i = 4; i <= n; i++) {
            if (i % 5 == 0)
                dp[i] = i / 5;
            else
                dp[i] = dp[i - 2] + 1;

        }

        System.out.println(dp[n]);
    }
}

package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 쉬운 거스름돈
public class SWEA1970 {

    static final int COINS = 8;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int money = Integer.parseInt(st.nextToken());
            //2차원배열은 1, 5, 10, 50, 100, 500, 1000, 5000의 개수를 담는다.
            int[] coins = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
            int[] answer = new int[COINS];

            for (int i = 0; i < COINS; i++) {
                answer[i] = money / coins[i];
                money %= coins[i];
            }

            sb.append("#").append(t + 1).append(" ").append("\n");
            for (int i = 0; i < COINS; i++) {
                sb.append(answer[i]).append(" ");
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}

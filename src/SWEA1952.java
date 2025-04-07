import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 수영장
public class SWEA1952 {

    static int answer;
    static int[] month;
    static int[] price;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            price = new int[4];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 4; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            month = new int[13];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i < 13; i++) {
                month[i] = Integer.parseInt(st.nextToken());
            }

            answer = price[3];

            dfs(1, 0);

            sb.append("#").append(t + 1).append(" ").append(answer);
            System.out.println(sb);
            sb.setLength(0);

        }


    }

    private static void dfs(int start, int sum) {

        if (start >= 13) {
            answer = Math.min(answer, sum);
            return;
        }

        if (sum >= answer) {
            return;
        }

        if (start == 0)
            dfs(start + 1, sum);
        else {
            dfs(start + 1, sum + price[0] * month[start]);

            dfs(start + 1, sum + price[1]);

            dfs(start + 3, sum + price[2]);
        }
    }
}

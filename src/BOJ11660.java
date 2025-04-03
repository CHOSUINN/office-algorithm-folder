import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구간 합 구하기 5
public class BOJ11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                sum += Integer.parseInt(st.nextToken());
                map[i][j] = sum;
            }
        }

        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < m; i++) {
            int total = 0;
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            for (int j = 0; j < (x2 - x1); j++) {
                total += map[x1][y2];

            }


            sb.append(total).append("\n");
        }
        System.out.println(sb);
    }
}
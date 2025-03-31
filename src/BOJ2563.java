import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이
public class BOJ2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[][] map = new int[100][100];
        int n = Integer.parseInt(st.nextToken());
        int answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // x, y는 색종이의 제일 좌측하단 꼭지점의 좌표
            for (int r = y; r < y + 10; r++)
                for (int c = x; c < x + 10; c++)
                    if (map[r][c] != 1) {
                        map[r][c] = 1;
                        answer++;
                    }
        }
        System.out.println(answer);
    }
}
